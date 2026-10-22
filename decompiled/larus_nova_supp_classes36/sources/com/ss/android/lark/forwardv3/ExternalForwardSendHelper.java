package com.ss.android.lark.forwardv3;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.dependency.ExternalForwardDirection;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.forwardv3.messageforward.MergeMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.OneByOneMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ExternalForwardSendHelper implements z {
    public static final /* synthetic */ int d = 0;
    public final ForwardV3ViewModel a;
    public final y.a b;
    public final ExternalForwardSendMode c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/forwardv3/ExternalForwardSendHelper$ExternalForwardErrorResult;", "Lcom/ss/android/lark/forwardv3/data/ForwardErrorResultV3;", INotificationHitPoint.NoticeType.MESSAGE, "", "showOnPartialSuccess", "", "<init>", "(Ljava/lang/String;Z)V", "getShowOnPartialSuccess", "()Z", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ExternalForwardErrorResult extends ForwardErrorResultV3 {
        private final boolean showOnPartialSuccess;

        public final boolean getShowOnPartialSuccess() {
            return this.showOnPartialSuccess;
        }

        public ExternalForwardErrorResult(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
            super(r2, false);
            this.showOnPartialSuccess = r3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/forwardv3/ExternalForwardSendHelper$Lane;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL", "EXTERNAL", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Lane extends Enum<Lane> {
        public static final Lane EXTERNAL = null;
        public static final Lane INTERNAL = null;
        public static final /* synthetic */ Lane[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Lane> getEntries() {
            return b;
        }

        static {
            Lane r0 = new Lane("INTERNAL", 0);
            INTERNAL = r0;
            Lane r1 = new Lane("EXTERNAL", 1);
            EXTERNAL = r1;
            Lane[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Lane[] values() {
            return (Lane[]) a.clone();
        }

        public static Lane valueOf(String r1) {
            return (Lane) r27.a.a(Lane.class, r1);
        }

        public Lane(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class MixedSendAggregator {
        public final y.a a;
        public final OnForwardContentListener b;
        public final Activity c;
        public final List<SearchBaseInfo> d;
        public final Object e;
        public int f;
        public boolean g;
        public boolean h;
        public ErrorResult i;
        public ErrorResult j;
        public rib.d k;
        public rib.d l;
        public Map<String, ? extends ForwardTargetBaseInfoNew> m;
        public Map<String, ? extends ForwardTargetBaseInfoNew> n;
        public boolean o;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Lane.values().length];
                r0[Lane.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[Lane.EXTERNAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public final Function0<Unit> a() {
            if (this.f == 0) goto L5;
        L82:
            return null;
        L5:
            if (this.g == true) goto L82;
            boolean r0 = true;
            this.g = true;
            if (this.h == true) goto L32;
            final ErrorResult r1 = this.i;
            if (r1 != null) goto L12;
            r1 = this.j;
        L12:
            if (r1 == null) goto L31;
            StringBuilder r2 = new StringBuilder("mixed external forward finish with all lanes failed: hasInternalError=");
            if (this.i == null) goto L16;
            boolean r6 = true;
        L17:
            r2.append(r6);
            r2.append(", hasExternalError=");
            if (this.j != null) goto L21;
            r0 = false;
        L21:
            r2.append(r0);
            r2.append(", errorCode=");
            r2.append(r1.getErrorCode());
            Log.w("NewForward", r2.toString());
            final OnForwardContentListener r3 = this.b;
            if (r3 == null) goto L29;
            final String r4 = r1.getDisplayMsg();
            if (r4 != null) goto L27;
            r4 = r1.getMessage();
        L27:
            return new ExternalForwardSendHelper$MixedSendAggregator$finishActionLocked$1(r3, r4, this, r1);
        L29:
            return new ExternalForwardSendHelper$MixedSendAggregator$finishActionLocked$2(this, r1);
        L16:
            r6 = false;
            goto L17
        L31:
            throw new IllegalStateException("mixed external forward finished without lane result".toString());
        L32:
            rib.d r5 = this.k;
            if (r5 != null) goto L37;
            r5 = this.l;
            if (r5 != null) goto L37;
            r5 = new rib.d(true);
        L37:
            final rib.d r12 = r5;
            ErrorResult r7 = this.j;
            if ((r7 instanceof ExternalForwardErrorResult) == false) goto L40;
            ExternalForwardErrorResult r8 = (ExternalForwardErrorResult) r7;
        L41:
            if (r8 != null) goto L43;
        L45:
            final ExternalForwardErrorResult r9 = null;
        L46:
            final OnForwardContentListener r10 = this.b;
            if (r10 == null) goto L65;
            final LinkedHashMap r11 = new LinkedHashMap();
            r11.putAll(this.m);
            r11.putAll(this.n);
            final boolean r13 = this.o;
            StringBuilder r14 = new StringBuilder("mixed external forward finish success: isPartialSuccess=");
            if (this.i == null) goto L51;
        L54:
            boolean r15 = true;
        L55:
            r14.append(r15);
            r14.append(", hasInternalError=");
            if (this.i == null) goto L58;
            boolean r16 = true;
        L59:
            r14.append(r16);
            r14.append(", hasExternalError=");
            if (this.j != null) goto L63;
            r0 = false;
        L63:
            r14.append(r0);
            r14.append(", hasContentListener=true, internalResultCount=");
            r14.append(this.m.size());
            r14.append(", externalResultCount=");
            r14.append(this.n.size());
            r14.append(", finalResultCount=");
            r14.append(r11.size());
            r14.append(", allowToast=");
            r14.append(r13);
            Log.i("NewForward", r14.toString());
            return new ExternalForwardSendHelper$MixedSendAggregator$finishActionLocked$3(r9, this, r10, r11, r13, r12);
        L58:
            r16 = false;
            goto L59
        L51:
            if (this.j != null) goto L54;
            r15 = false;
            goto L55
        L65:
            StringBuilder r17 = new StringBuilder("mixed external forward finish success: isPartialSuccess=");
            if (this.i == null) goto L68;
        L71:
            boolean r18 = true;
        L72:
            r17.append(r18);
            r17.append(", hasInternalError=");
            if (this.i == null) goto L75;
            boolean r19 = true;
        L76:
            r17.append(r19);
            r17.append(", hasExternalError=");
            if (this.j != null) goto L80;
            r0 = false;
        L80:
            r17.append(r0);
            r17.append(", hasContentListener=false");
            Log.i("NewForward", r17.toString());
            return new ExternalForwardSendHelper$MixedSendAggregator$finishActionLocked$4(r9, this, r12);
        L75:
            r19 = false;
            goto L76
        L68:
            if (this.j != null) goto L71;
            r18 = false;
            goto L72
        L43:
            if (r8.getShowOnPartialSuccess() == false) goto L45;
            r9 = r8;
            goto L46
        L40:
            r8 = null;
            goto L41
        }

        public MixedSendAggregator(y.a r2, OnForwardContentListener r3, Activity r4, List<? extends SearchBaseInfo> r5, boolean r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            Intrinsics.checkNotNullParameter(r5, "originItems");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = new Object();
            int r8 = r6 ? 1 : 0;
            this.f = (r7 ? 1 : 0) + r8;
            this.m = MapsKt.emptyMap();
            this.n = MapsKt.emptyMap();
            this.o = true;
        }
    }

    public static final class a {
        @JvmStatic
        public static List a(ForwardV3ViewModel r2) {
            Intrinsics.checkNotNullParameter(r2, "viewModel");
            IForwardContent r0 = r2.getForwardContent();
            if ((r0 instanceof MergeMessageForwardContent) == false) goto L9;
            MergeMessageForwardContent r1 = (MergeMessageForwardContent) r0;
            if (r1.e == false) goto L21;
            return CollectionsKt.listOf(r1.f);
        L21:
            return r1.c;
        L9:
            if ((r0 instanceof OneByOneMessageForwardContent) == false) goto L12;
            return ((OneByOneMessageForwardContent) r0).c;
        L12:
            if ((r0 instanceof SingleMessageForwardContent) == false) goto L19;
            Message r3 = r2.getSourceMessage();
            if (r3 == null) goto L16;
            String r4 = r3.getId();
        L23:
            return CollectionsKt.listOfNotNull(r4);
        L16:
            r4 = null;
            goto L23
        L19:
            return CollectionsKt.emptyList();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IExternalForwardExecutor.ExternalForwardFailureReason.values().length];
            r0[IExternalForwardExecutor.ExternalForwardFailureReason.MESSAGE_CONTENT_TOO_LARGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[IExternalForwardExecutor.ExternalForwardFailureReason.UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static ForwardErrorResultV3 b(IExternalForwardExecutor.ExternalForwardFailureReason r4) {
        int r0 = b.a[r4.ordinal()];
        boolean r1 = true;
        if (r0 != 1) goto L5;
        int r2 = 2131891059;
    L10:
        String r3 = y9c.d.h(r2);
        if (r4 == IExternalForwardExecutor.ExternalForwardFailureReason.MESSAGE_CONTENT_TOO_LARGE) goto L15;
        r1 = false;
    L15:
        return new ExternalForwardErrorResult(r3, r1);
    L5:
        if (r0 != 2) goto L8;
        r2 = 2131891584;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public ExternalForwardSendHelper(ForwardV3ViewModel r2, y.a r3, ExternalForwardSendMode r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "sendMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.ss.android.lark.forwardv3.z
    public final void a(LifecycleCoroutineScope r29, Context r30, List r31, String r32, RichText r33) {
        Intrinsics.checkNotNullParameter(r29, "scope");
        Intrinsics.checkNotNullParameter(r30, "context");
        Intrinsics.checkNotNullParameter(r31, "items");
        Intrinsics.checkNotNullParameter(r32, "note");
        Intrinsics.checkNotNullParameter(r33, "richText");
        Log.i("NewForward", "external forward launch: sendMode=" + this.c + ", itemCount=" + r31.size() + ", enableExternalTarget=" + this.a.getEnableExternalTarget());
        if (r31.isEmpty() == false) goto L7;
        Log.w("NewForward", "launchForwardTask with empty items");
        this.b.onError(b(IExternalForwardExecutor.ExternalForwardFailureReason.UNKNOWN));
        return;
    L7:
        if (this.c.getExecutorDirection$forward_new_release() == null) goto L14;
        ExternalForwardDirection r0 = this.c.getExecutorDirection$forward_new_release();
        IExternalForwardExecutor r6 = ForwardModuleV3.a().getExternalForwardExecutor(r0, "", CollectionsKt.emptyList(), "", false, "");
        if (r6 == null) goto L11;
        c(r29, r30, r31, r32, r33, r6, this.b, null);
        return;
    L11:
        Log.e("NewForward", r0.getValue() + " executor is null, send failed");
        this.b.onError(b(IExternalForwardExecutor.ExternalForwardFailureReason.UNKNOWN));
        return;
    L14:
        if (this.a.getEnableExternalTarget() == false) goto L16;
        String r1 = ForwardModuleV3.a().getExternalTargetId();
    L18:
        if (r1 != null) goto L20;
    L23:
        boolean r2 = true;
    L24:
        if (r2 == false) goto L26;
        Pair r3 = TuplesKt.to(CollectionsKt.emptyList(), r31);
    L34:
        List r16 = (List) r3.component1();
        List r17 = (List) r3.component2();
        boolean r18 = !r16.isEmpty();
        boolean r19 = !r17.isEmpty();
        if (r18 == false) goto L38;
        if (r19 == false) goto L38;
        boolean r20 = true;
    L39:
        y.a r4 = this.b;
        OnForwardContentListener r5 = this.a.getForwardContentListener();
        if (r20 == false) goto L42;
        OnForwardContentListener r7 = r5;
    L44:
        if ((r30 instanceof Activity) == false) goto L46;
        Activity r8 = (Activity) r30;
    L47:
        final MixedSendAggregator r9 = new MixedSendAggregator(r4, r7, r8, r31, r19, r18);
        final Lane r10 = Lane.INTERNAL;
        com.ss.android.lark.forwardv3.b r11 = new com.ss.android.lark.forwardv3.b(r9, r10);
        final Lane r12 = Lane.EXTERNAL;
        com.ss.android.lark.forwardv3.b r13 = new com.ss.android.lark.forwardv3.b(r9, r12);
        if (r20 == false) goto L50;
        Intrinsics.checkNotNullParameter(r10, "lane");
        OnForwardContentListener r14 = new ExternalForwardSendHelper$MixedSendAggregator$createForwardContentListener$1(r9, r10);
    L51:
        if (r20 == false) goto L53;
        Intrinsics.checkNotNullParameter(r12, "lane");
        OnForwardContentListener r15 = new ExternalForwardSendHelper$MixedSendAggregator$createForwardContentListener$1(r9, r12);
    L54:
        if (r18 == false) goto L102;
        IForwardContent r21 = this.a.getForwardContent();
        boolean r22 = r21 instanceof MergeMessageForwardContent;
        if (r22 == false) goto L58;
        MergeMessageForwardContent r23 = (MergeMessageForwardContent) r21;
    L59:
        if (r23 == null) goto L61;
        String r24 = r23.d;
    L62:
        String r25 = "";
        if (r24 != null) goto L65;
        String r26 = "";
    L66:
        List<String> r27 = a.a(this.a);
        boolean r28 = r21 instanceof SingleMessageForwardContent;
        if (r28 == false) goto L69;
        SingleMessageForwardContent r110 = (SingleMessageForwardContent) r21;
    L70:
        if (r110 != null) goto L72;
    L74:
        boolean r210 = false;
    L75:
        if (r22 == false) goto L78;
        String r111 = ((MergeMessageForwardContent) r21).h;
    L87:
        String r211 = r111;
    L89:
        if (r22 == false) goto L93;
        r25 = ((MergeMessageForwardContent) r21).b;
    L97:
        IExternalForwardExecutor r112 = ForwardModuleV3.a().getExternalForwardExecutor(ExternalForwardDirection.LARK_TO_DOUBAO, r26, r27, r211, r210, r25);
        if (r112 == null) goto L100;
        c(r29, r30, r16, r32, r33, r112, r13, r15);
        goto L102
    L100:
        Log.e("NewForward", "lark2doubao executor is null, external target send failed");
        r13.onError(b(IExternalForwardExecutor.ExternalForwardFailureReason.UNKNOWN));
        goto L102
    L93:
        if ((r21 instanceof OneByOneMessageForwardContent) == false) goto L95;
        r25 = ((OneByOneMessageForwardContent) r21).b;
        goto L97
    L95:
        if (r28 == false) goto L97;
        r25 = ((SingleMessageForwardContent) r21).b;
        goto L97
    L78:
        if ((r21 instanceof OneByOneMessageForwardContent) == false) goto L80;
        r111 = ((OneByOneMessageForwardContent) r21).d;
        goto L87
    L80:
        if (r28 == false) goto L88;
        Message r113 = this.a.getSourceMessage();
        if (r113 == null) goto L84;
        r111 = r113.getChatId();
    L85:
        if (r111 != null) goto L87;
    L84:
        r111 = null;
    L88:
        r211 = "";
        goto L89
    L72:
        if (r110.d != true) goto L74;
        r210 = true;
        goto L75
    L69:
        r110 = null;
        goto L70
    L65:
        r26 = r24;
        goto L66
    L61:
        r24 = null;
        goto L62
    L58:
        r23 = null;
    L102:
        if (r19 == false) goto L112;
        new y(this.a, r11, r14).a(r29, r30, r17, r32, r33);
        return;
    L112:
        return;
    L53:
        r15 = null;
        goto L54
    L50:
        r14 = null;
        goto L51
    L46:
        r8 = null;
        goto L47
    L42:
        r7 = null;
    L38:
        r20 = false;
        goto L39
    L26:
        ArrayList r34 = new ArrayList();
        ArrayList r35 = new ArrayList();
        Iterator r36 = r31.iterator();
    L28:
        if (r36.hasNext() == false) goto L33;
        Object r37 = r36.next();
        if (Intrinsics.areEqual(((SearchBaseInfo) r37).getId(), r1) == true) goto L31;
        r35.add(r37);
        goto L28
    L31:
        r34.add(r37);
        goto L28
    L33:
        r3 = new Pair(r34, r35);
        goto L34
    L20:
        if (r1.length() == 0) goto L23;
        r2 = false;
        goto L24
    L16:
        r1 = null;
        goto L18
    }

    public final void c(LifecycleCoroutineScope r14, Context r15, List r16, String r17, RichText r18, IExternalForwardExecutor r19, y.a r20, OnForwardContentListener r21) {
        BuildersKt.launch$default(r14, null, null, new ExternalForwardSendHelper$executeExternalForward$1(r21, this, r15, r20, r16, r19, r17, r18, null), 3, null);
    }
}
