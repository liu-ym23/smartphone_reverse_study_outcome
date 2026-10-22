package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.business.stateservice.api.StateServiceApi;
import com.bytedance.android.livesdk.business.stateservice.api.ToolBarComponentSwitchResponse;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public final String a;
    public final ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a> b;
    public r c;
    public final String d;
    public final Lazy e;
    public final DataCenter f;
    public final int g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ s b;
        public final /* synthetic */ s c;
        public final /* synthetic */ i d;

        public a(d r1, s r2, s r3, i r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r8) {
            Response r9 = (Response) r8;
            Logger.i(this.a.a, "change success from " + this.b + " to " + this.c);
            ALogger.i("NewToolbarLog", "change success from " + this.b + " to " + this.c);
            d r0 = this.a;
            s r1 = this.b;
            Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a> r2 = r0.b.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a r3 = r2.next();
            r3.getClass();
            Intrinsics.checkNotNullParameter(r1, "from");
            if (r3.a.contains(Integer.valueOf(r1.a)) == false) goto L4;
            r3.a();
            goto L4
        L8:
            i r4 = this.d;
            if (r4 == null) goto L17;
            s r5 = this.b;
            List r6 = ((ToolBarComponentSwitchResponse) ((BaseResponse) r9).data).componentData;
            if (r6 == null) goto L15;
            ToolbarComponentData r7 = (ToolbarComponentData) CollectionsKt.getOrNull(r6, 0);
            if (r7 == null) goto L15;
            Intrinsics.checkNotNullParameter(r7, "$this$toModel");
            int r10 = s.q;
            s r11 = s.a.a(r7);
        L16:
            r4.b(r5, r11, true);
        L15:
            r11 = this.c;
        L17:
            d r12 = this.a;
            List r13 = ((ToolBarComponentSwitchResponse) ((BaseResponse) r9).data).componentData;
            if (r13 == null) goto L22;
            ToolbarComponentData r14 = (ToolbarComponentData) CollectionsKt.getOrNull(r13, 0);
            if (r14 == null) goto L22;
            Intrinsics.checkNotNullParameter(r14, "$this$toModel");
            int r15 = s.q;
            s r16 = s.a.a(r14);
        L23:
            r r17 = r12.c;
            if (r17 == null) goto L32;
            s r18 = new s();
            Intrinsics.checkNotNullParameter(r18, "from");
            Intrinsics.checkNotNullParameter(r16, "to");
            r17.h(r18);
            r17.c(r18);
            r17.a(r16);
            r17.g.a(new r.b(r18, r16, 6, null));
            return;
        L32:
            return;
        L22:
            r16 = this.c;
            goto L23
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ s b;
        public final /* synthetic */ s c;
        public final /* synthetic */ i d;
        public final /* synthetic */ long e;

        public b(d r1, s r2, s r3, i r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            Logger.e(this.a.a, "change error from " + this.b + " to " + this.c);
            i r0 = this.d;
            if (r0 == null) goto L5;
            r0.b(this.b, this.c, false);
        L5:
            StringCompanionObject r1 = StringCompanionObject.INSTANCE;
            ALogger.e("NewToolbarLog", String.format("%d change %s to %s", Arrays.copyOf(new Object[]{Long.valueOf(this.e), this.b.b, this.c.b}, 3)), r7);
            boolean r2 = r7 instanceof CustomApiServerException;
            String r3 = null;
            if (r2 == true) goto L8;
            Throwable r4 = null;
        L9:
            CustomApiServerException r5 = (CustomApiServerException) r4;
            if (r5 == null) goto L12;
            String r8 = r5.getPrompt();
        L14:
            if (TextUtils.isEmpty(r8) == false) goto L16;
            r3 = s1.B(2131922687);
        L21:
            f2.c(r3, 1);
            return;
        L16:
            if (r2 == true) goto L18;
            r7 = null;
        L18:
            CustomApiServerException r9 = (CustomApiServerException) r7;
            if (r9 == null) goto L21;
            r3 = r9.getPrompt();
            goto L21
        L12:
            r8 = null;
            goto L14
        L8:
            r4 = r7;
            goto L9
        }
    }

    public static final class c extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a {
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ List c;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a
        public final void a() {
            this.b.invoke();
        }

        public c(Function0 r1, List r2, List r3) {
            this.b = r1;
            this.c = r2;
            Intrinsics.checkNotNullParameter(r3, "list");
            this.a.addAll(r3);
        }
    }

    public d(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.f = r5;
        this.g = 0;
        this.a = "ReplaceDialog";
        this.b = new ArrayList();
        this.d = ",";
        this.e = LazyKt.lazy(ButtonReplaceDialogManager$gameCommerceReplaceDialogModify$2.INSTANCE);
        Function0<Unit> r0 = new ButtonReplaceDialogManager$1(this);
        Intrinsics.checkNotNullParameter(r0, "action");
        d(CollectionsKt.arrayListOf(new Integer[]{5}), r0);
        d(CollectionsKt.arrayListOf(new Integer[]{3}), ButtonReplaceDialogManager$2.INSTANCE);
        d(CollectionsKt.arrayListOf(new Integer[]{6}), ButtonReplaceDialogManager$3.INSTANCE);
    }

    public static boolean c(s r1) {
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L9;
        int r2 = r1.a;
        if (r2 != 6) goto L7;
    L8:
        return true;
    L7:
        if (r2 == 9) goto L8;
    L9:
        return false;
    }

    public static boolean a(int r5, List r6) {
        Object r2 = null;
        if (r6 == null) goto L14;
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L13;
        Object r3 = r7.next();
        if (((s) r3).a != r5) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r2 = r3;
        goto L13
    L10:
        r4 = false;
    L13:
        r2 = (s) r2;
    L14:
        if (r2 == null) goto L22;
        return true;
    L22:
        return false;
    }

    public final void d(List<Integer> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "action");
        c r0 = new c(r3, r2, r2);
        Intrinsics.checkNotNullParameter(r0, "handler");
        this.b.add(r0);
    }

    public final void b(long r11, s r13, s r14, i r15) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.f, 0, 2);
        if (r0 == null) goto L14;
        com.bytedance.live.datacontext.n r1 = r0.getCurToolbarList();
        if (r1 == null) goto L14;
        List r2 = (List) r1.getValue();
        if (r2 == null) goto L14;
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r4.add(String.valueOf(((s) r5.next()).a));
        goto L10
    L12:
        String r6 = CollectionsKt.joinToString$default(r4, this.d, null, null, 0, null, null, 62, null);
        if (r6 == null) goto L14;
    L15:
        String r7 = r6;
        Logger.i(this.a, "change from " + r13 + " to " + r14);
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((StateServiceApi) com.bytedance.android.live.network.c.b().e(StateServiceApi.class)).switchFunction(r7, r11, "", String.valueOf(r14.a)).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r13, r14, r15), new b(this, r13, r14, r15, r11));
        return;
    L14:
        r6 = "";
        goto L15
    }
}
