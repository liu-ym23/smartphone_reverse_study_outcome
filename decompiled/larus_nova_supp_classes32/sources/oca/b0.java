package oca;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.lynx.canvas.camera.CameraSize;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.ShowAllDialogFragment;
import com.obric.assistant.card.databinding.ObricHybridEntityListBinding;
import com.obric.assistant.card.layout.DividerItemMarginDecoration;
import com.obric.assistant.card.layout.adapter.AppEntityListAdapter;
import com.obric.assistant.card.manager.NetEaseMusicManager;
import com.obric.capabilitykit.common.CardProvider;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 extends oca.b {
    public final Lazy x;
    public final Set<String> y;
    public List<? extends Object> z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AppEntityListAdapter.HeaderType.values().length];
            r0[AppEntityListAdapter.HeaderType.LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[AppEntityListAdapter.HeaderType.INSTRUCTION_MANAGEMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[AppEntityListAdapter.HeaderType.CLOCK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[AppEntityListAdapter.HeaderType.CONTACTS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[AppEntityListAdapter.HeaderType.SMS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[AppEntityListAdapter.HeaderType.ALBUM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[AppEntityListAdapter.HeaderType.NOTE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[AppEntityListAdapter.HeaderType.MEMORY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[AppEntityListAdapter.HeaderType.RECORDING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[AppEntityListAdapter.HeaderType.NETEASE_MUSIC.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    public static final class c implements pca.b {
        public final /* synthetic */ Message a;
        public final /* synthetic */ b0 b;

        public c(Message r1, b0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // pca.b
        public final void a(List<? extends Object> r5, Object r6, final int r7) {
            Intrinsics.checkNotNullParameter(r5, "entityGroup");
            Intrinsics.checkNotNullParameter(r6, "entity");
            if (com.obric.assistant.card.utils.b.b(r5, r6) == false) goto L6;
            return;
        L6:
            if ((r6 instanceof AppEntity) == false) goto L21;
            if ((r6 instanceof MusicEntity) == false) goto L19;
            NetEaseMusicManager r0 = NetEaseMusicManager.a;
            String r1 = this.a.getLocalMessageId();
            MusicEntity r8 = (MusicEntity) r6;
            String r2 = r8.getId();
            r0.getClass();
            if (NetEaseMusicManager.d(r1, r2) == false) goto L12;
            NetEaseMusicManager.b(this.b.getTraceInfo(), true, r7);
            return;
        L12:
            String r3 = this.a.getLocalMessageId();
            ArrayList r4 = new ArrayList();
            Iterator<T> r9 = r5.iterator();
        L14:
            if (r9.hasNext() == false) goto L18;
            Object r10 = r9.next();
            if ((r10 instanceof MusicEntity) == false) goto L14;
            r4.add(r10);
            goto L14
        L18:
            MusicEntity[] r11 = (MusicEntity[]) r4.toArray(new MusicEntity[0]);
            final b0 r12 = this.b;
            NetEaseMusicManager.f(r3, r11, r8, new c0(r12, r7));
            return;
        L19:
            com.obric.assistant.card.utils.b.c((AppEntity) r6);
            return;
        L21:
            if ((r6 instanceof mca.b) == false) goto L27;
            T r13 = ((mca.b) r6).a;
            if ((r13 instanceof AppEntity) == false) goto L25;
            com.obric.assistant.card.utils.b.c((AppEntity) r13);
            return;
        L25:
            FLogger.a.e("HybridAppEntityBox", "onItemClick: entity is not AppEntity");
            return;
        L27:
            if ((r6 instanceof CardProvider) == false) goto L29;
            FLogger.a.i("HybridAppEntityBox", "clicked remote card cardUri = " + ((CardProvider) r6).getCardUri());
            return;
        L29:
            FLogger.a.e("HybridAppEntityBox", "onItemClick: entity is not AppEntity");
        }
    }

    static {
    }

    private final ObricHybridEntityListBinding getBinding() {
        return (ObricHybridEntityListBinding) this.x.getValue();
    }

    public b0(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        FLogger.a.i("HybridAppEntityBox", "init");
        this.x = LazyKt.lazy(new j(r4, this));
        this.y = Collections.newSetFromMap(new ConcurrentHashMap());
        this.z = CollectionsKt.emptyList();
    }

    public static Unit t(b0 r1) {
        r1.getBinding().d.setImageResource(2131244317);
        return Unit.INSTANCE;
    }

    public static boolean u(AppIntentMessage r5) {
        List<Parcelable> r0 = com.obric.assistant.card.utils.c.d(r5);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        List<Parcelable> r6 = com.obric.assistant.card.utils.c.d(r5);
        if (r6 != null) goto L14;
        r6 = CollectionsKt.emptyList();
    L14:
        ArrayList r2 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L16:
        if (r7.hasNext() == false) goto L23;
        Object r3 = (Parcelable) r7.next();
        if ((r3 instanceof AppIntentCardData) == false) goto L20;
        r3 = com.obric.assistant.card.utils.c.c((AppIntentCardData) r3);
    L20:
        if (r3 == null) goto L16;
        r2.add(r3);
        goto L16
    L23:
        if ((!r2.isEmpty()) == true) goto L25;
    L36:
        return false;
    L25:
        if (r2.isEmpty() == true) goto L33;
        Iterator r8 = r2.iterator();
    L29:
        if (r8.hasNext() == false) goto L33;
        if ((r8.next() instanceof MusicEntity) == false) goto L29;
        boolean r9 = true;
    L34:
        if (r9 == false) goto L36;
        return true;
    L33:
        r9 = false;
        goto L34
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final BitmapDrawable C(Drawable r8) {
        if ((r8 instanceof BitmapDrawable) == false) goto L7;
        BitmapDrawable r0 = (BitmapDrawable) r8;
        if (r0.getBitmap() == null) goto L7;
        return r0;
    L7:
        Integer r1 = Integer.valueOf(r8.getIntrinsicWidth());
        boolean r2 = true;
        if (r1.intValue() <= 0) goto L10;
        boolean r3 = true;
    L11:
        Integer r4 = null;
        if (r3 == true) goto L15;
        r1 = null;
    L15:
        int r5 = CameraSize.lowWidth;
        if (r1 == null) goto L18;
        int r6 = r1.intValue();
    L19:
        Integer r7 = Integer.valueOf(r8.getIntrinsicHeight());
        if (r7.intValue() > 0) goto L23;
        r2 = false;
    L23:
        if (r2 == false) goto L25;
        r4 = r7;
    L25:
        if (r4 == null) goto L27;
        r5 = r4.intValue();
    L27:
        Rect r9 = new Rect(r8.getBounds());
        Bitmap r10 = Bitmap.createBitmap(r6, r5, Bitmap.Config.ARGB_8888);
        r8.setBounds(0, 0, r6, r5);
        r8.draw(new Canvas(r10));
        r8.setBounds(r9);
        return new BitmapDrawable(getResources(), r10);
    L18:
        r6 = CameraSize.lowWidth;
        goto L19
    L10:
        r3 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(String r5) {
        Intent r0 = getContext().getPackageManager().getLaunchIntentForPackage(r5);
        if (r0 != null) goto L7;
        FLogger.a.w("HybridAppEntityBox", "openAppByPackage: launch intent not found, packageName=".concat(r5));
        return;
    L7:
        if ((getContext() instanceof Activity) == true) goto L17;
        r0.addFlags(268435456);
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        getContext().startActivity(r0);     // Catch: Throwable -> L11
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r3 = Result.exceptionOrNull-impl(r1);
        if (r3 == null) goto L19;
        FLogger.a.e("HybridAppEntityBox", "openAppByPackage failed, packageName=".concat(r5), r3);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(List<String> r3) {
        getBinding().i.setOnClickListener(null);
        e1.o(getBinding().d);
        e1.o(getBinding().b);
        e1.x(getBinding().h);
        TextView r0 = getBinding().h;
        int r1 = com.obric.assistant.card.utils.e.a;
        r0.setText(com.obric.assistant.card.utils.e.a(getContext(), r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // oca.b
    public final void o(final AppIntentMessage r17, final Message r18) {
        Intrinsics.checkNotNullParameter(r17, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r18, "message");
        n(getBinding().a, v19.c.a(2130970533, getContext(), 2131102542));
        if (u(r17) == false) goto L5;
        NetEaseMusicManager r3 = NetEaseMusicManager.a;
        Context r4 = getContext();
        r3.getClass();
        setEnable(NetEaseMusicManager.c(r4));
    L5:
        List<Parcelable> r5 = com.obric.assistant.card.utils.c.d(r17);
        if (r5 != null) goto L8;
        r5 = CollectionsKt.emptyList();
    L8:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L16;
        Object r8 = (Parcelable) r7.next();
        if ((r8 instanceof AppIntentCardData) == false) goto L14;
        r8 = com.obric.assistant.card.utils.c.b((AppIntentCardData) r8);
    L14:
        if (r8 == null) goto L10;
        r6.add(r8);
        goto L10
    L16:
        this.z = r6;
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        c r10 = new c(r18, this);
        ArrayList r11 = new ArrayList();
        AtMostHeightRecyclerView r12 = getBinding().c;
        if (r12.getLayoutManager() != null) goto L19;
        r12.setLayoutManager(new LinearLayoutManager(r12.getContext(), 1, false));
    L19:
        List<? extends Object> r13 = this.z;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L21:
        if (r15.hasNext() == false) goto L27;
        Object r16 = r15.next();
        if ((r16 instanceof AppIntentCardData) == false) goto L25;
        r16 = com.obric.assistant.card.utils.c.c((AppIntentCardData) r16);
    L25:
        if (r16 == null) goto L21;
        r14.add(r16);
        goto L21
    L27:
        boolean r19 = com.obric.assistant.card.utils.b.d(r14);
        if (r12.getItemDecorationCount() > 0) goto L39;
        if (Intrinsics.areEqual(r18.getBizContentType(), OAppIntentBizContentType.MUSIC_CARD) == false) goto L32;
        r12.addItemDecoration(new DividerItemMarginDecoration(r12.getContext().getResources().getDimensionPixelSize(2131165850), r12.getContext().getResources().getColor(2131103685), r12.getContext().getResources().getDimensionPixelSize(2131166280), 0));
    L37:
        r12.getItemDecorationCount();
        goto L39
    L32:
        int r110 = r12.getContext().getResources().getDimensionPixelSize(2131165850);
        int r111 = r12.getContext().getResources().getColor(2131103685);
        Resources r112 = r12.getContext().getResources();
        if (r19 == false) goto L35;
        int r20 = 2131165925;
    L36:
        r12.addItemDecoration(new DividerItemMarginDecoration(r110, r111, r112.getDimensionPixelSize(r20), r12.getContext().getResources().getDimensionPixelSize(2131165925)));
        goto L37
    L35:
        r20 = 2131166241;
    L39:
        if (r14.isEmpty() == false) goto L41;
    L66:
        boolean r21 = false;
    L67:
        if (r21 == false) goto L72;
    L69:
        if (r12.getItemDecorationCount() <= 0) goto L72;
        r12.removeItemDecorationAt(0);
    L72:
        if (r12.getAdapter() != null) goto L74;
        r12.setAdapter(new AppEntityListAdapter(AppEntityListAdapter.PageType.ChatPage));
        boolean r22 = true;
    L76:
        if (this.y.contains(r18.getLocalMessageId()) == false) goto L79;
        int r113 = Integer.MAX_VALUE;
    L85:
        RecyclerView.Adapter r114 = r12.getAdapter();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type com.obric.assistant.card.layout.adapter.AppEntityListAdapter");
        final AppEntityListAdapter r115 = (AppEntityListAdapter) r114;
        Function0<Bundle> r116 = new p(this);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "traceInfo");
        r115.h = r116;
        r115.A2(com.obric.assistant.card.utils.c.a(r17, r18), this.z, r113);
        r115.f = this.q;
        r115.g = getMessageId();
        if (r115.c.size() != 1) goto L94;
        Object r117 = ListProtector.get(r115.c, 0);
        if ((r117 instanceof mca.c) == false) goto L94;
        Boolean r118 = Boolean.TRUE;
        mca.c r119 = (mca.c) r117;
        Integer r23 = Integer.valueOf(r119.a.size());
        if (r119.a.size() <= 6) goto L92;
        boolean r120 = true;
    L93:
        Triple r121 = new Triple(r118, r23, Boolean.valueOf(r120));
    L112:
        boolean r24 = ((Boolean) r121.component1()).booleanValue();
        ((Number) r121.component2()).intValue();
        boolean r122 = ((Boolean) r121.component3()).booleanValue();
        getBinding().e.setVisibility(0);
        if (r24 == false) goto L115;
        e1.o(getBinding().j);
        getBinding().j.setOnLongClickListener(null);
    L167:
        Context r25 = r12.getContext();
        Intrinsics.checkNotNullParameter(r25, "context");
        List<AppEntityListAdapter.b> r26 = r115.z2(r25);
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r27 = r26.iterator();
    L169:
        if (r27.hasNext() == false) goto L171;
        r123.add(((AppEntityListAdapter.b) r27.next()).a);
        goto L169
    L171:
        CollectionsKt.addAll(r11, r123);
        Context r28 = r12.getContext();
        Intrinsics.checkNotNullParameter(r28, "context");
        AppEntityListAdapter.b r29 = (AppEntityListAdapter.b) CollectionsKt.firstOrNull(r115.z2(r28));
        if (r29 == null) goto L174;
        AppEntityListAdapter.HeaderType r30 = r29.b;
    L175:
        r9.element = r30;
        Unit r31 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        if (r22 == true) goto L178;
        r115.notifyDataSetChanged();
    L178:
        r115.i = new d0(r10, this);
        r115.j = new e0(this);
        RoundRelativeLayout r32 = getBinding().a;
        RecyclerView.Adapter r33 = getBinding().c.getAdapter();
        if (r33 == null) goto L181;
        int r34 = r33.getItemCount();
    L183:
        if (r34 != 0) goto L185;
        FLogger.a.w("HybridAppEntityBox", "no item in recyclerView");
        int r35 = 8;
    L186:
        r32.setVisibility(r35);
        AppEntityListAdapter.HeaderType r36 = (AppEntityListAdapter.HeaderType) r9.element;
        String r37 = (String) CollectionsKt.firstOrNull(r11);
        if (r37 != null) goto L189;
        y(r11);
    L209:
        RecyclerView.Adapter r38 = getBinding().c.getAdapter();
        if (r38 == null) goto L212;
        int r39 = r38.getItemCount();
    L214:
        if (r17.getNeedConfirm() == true) goto L216;
    L242:
        boolean r40 = false;
    L243:
        if (r40 == false) goto L245;
        getBinding().f.setVisibility(0);
        getBinding().g.setText(r17.getConfirmNlg());
        e1.d(getBinding().f, new s(this, r18, r17));
        return;
    L245:
        getBinding().f.setVisibility(8);
        getBinding().g.setText(NameKeys.UnloadStrategy_No_Strategy);
        return;
    L216:
        if (o0.d(r17.getConfirmNlg()) == false) goto L242;
        if (r39 <= 0) goto L242;
        String r41 = r18.getBizContentType();
        if (r41 == null) goto L242;
        switch(r41.hashCode()) {
            case -1849462795: goto L239;
            case 406933063: goto L236;
            case 870102364: goto L233;
            case 1733068456: goto L230;
            case 1787939047: goto L227;
            case 1866992267: goto L224;
            default: goto L242;
        };
    L224:
        if (r41.equals(OAppIntentBizContentType.RECORDER_CARD) == false) goto L242;
    L241:
        r40 = true;
        goto L243
    L227:
        if (r41.equals(OAppIntentBizContentType.PHONE_CARD) == true) goto L241;
    L230:
        if (r41.equals(OAppIntentBizContentType.MEMORY_CARD) == true) goto L241;
    L233:
        if (r41.equals(OAppIntentBizContentType.SMS_CARD) == true) goto L241;
    L236:
        if (r41.equals(OAppIntentBizContentType.CLOCK_CARD) == false) goto L242;
    L239:
        if (r41.equals(OAppIntentBizContentType.CONTACT_CARD) == true) goto L241;
    L212:
        r39 = 0;
        goto L214
    L189:
        if (r36 != null) goto L191;
        int r42 = -1;
    L192:
        switch(r42) {
            case -1: goto L208;
            case 0: goto L194;
            case 1: goto L207;
            case 2: goto L206;
            case 3: goto L205;
            case 4: goto L204;
            case 5: goto L203;
            case 6: goto L202;
            case 7: goto L201;
            case 8: goto L200;
            case 9: goto L199;
            case 10: goto L195;
            default: goto L194;
        };
    L195:
        NetEaseMusicManager r43 = NetEaseMusicManager.a;
        Context r44 = getContext();
        r43.getClass();
        if (NetEaseMusicManager.c(r44) == true) goto L198;
        y(r11);
        goto L209
    L198:
        B(this, r37, null, new w(this), 6);
        goto L209
    L199:
        B(this, r37, null, new v(this), 6);
        goto L209
    L200:
        B(this, r37, null, new u(this), 6);
        goto L209
    L201:
        B(this, r37, null, new o(this), 6);
        goto L209
    L202:
        B(this, r37, new m(this), new n(this), 2);
        goto L209
    L203:
        B(this, r37, null, new l(this), 6);
        goto L209
    L204:
        B(this, r37, null, new k(this), 6);
        goto L209
    L205:
        B(this, r37, new z(this), new a0(this), 2);
        goto L209
    L206:
        z(r37, 2131103858, new x(this), new y(this));
        goto L209
    L207:
        B(this, r37, null, new t(this), 6);
        goto L209
    L208:
        y(r11);
        goto L209
    L194:
        throw new NoWhenBranchMatchedException();
    L191:
        r42 = b.a[r36.ordinal()];
        goto L192
    L185:
        r35 = 0;
        goto L186
    L181:
        r34 = 0;
        goto L183
    L174:
        r30 = null;
        goto L175
    L115:
        if (r122 == false) goto L166;
        e1.x(getBinding().j);
        getBinding().j.setAlpha(1.0f);
        getBinding().j.setEnabled(true);
        if (r17.getNeedConfirm() == true) goto L119;
    L121:
        final boolean r124 = false;
    L122:
        List<Parcelable> r45 = com.obric.assistant.card.utils.c.d(r17);
        if (r45 != null) goto L125;
    L128:
        boolean r46 = true;
    L129:
        if (r46 == true) goto L156;
        List<Parcelable> r47 = com.obric.assistant.card.utils.c.d(r17);
        if (r47 != null) goto L134;
        r47 = CollectionsKt.emptyList();
    L134:
        ArrayList r125 = new ArrayList();
        Iterator<T> r48 = r47.iterator();
    L136:
        if (r48.hasNext() == false) goto L143;
        Object r126 = (Parcelable) r48.next();
        if ((r126 instanceof AppIntentCardData) == false) goto L140;
        r126 = com.obric.assistant.card.utils.c.c((AppIntentCardData) r126);
    L140:
        if (r126 == null) goto L136;
        r125.add(r126);
        goto L136
    L143:
        if ((!r125.isEmpty()) == false) goto L156;
        if (r125.isEmpty() == true) goto L153;
        Iterator r49 = r125.iterator();
    L149:
        if (r49.hasNext() == false) goto L153;
        if ((r49.next() instanceof AlarmEntity) == true) goto L149;
        boolean r50 = false;
    L154:
        if (r50 == false) goto L156;
        boolean r51 = true;
    L157:
        if (r51 == true) goto L159;
    L161:
        e1.d(getBinding().j, new r(r124, this, r18, r115));
        TextView r52 = getBinding().k;
        if (Intrinsics.areEqual(r18.getBizContentType(), OAppIntentBizContentType.MUSIC_CARD) == false) goto L164;
        String r127 = getContext().getString(2131912008);
    L165:
        r52.setText(r127);
        goto L167
    L164:
        r127 = getContext().getString(2131912197);
        goto L165
    L159:
        if (this.q == true) goto L161;
        getBinding().j.setEnabled(false);
        getBinding().j.setAlpha(0.3f);
        getBinding().j.setOnClickListener(null);
        getBinding().j.setOnLongClickListener(null);
    L153:
        r50 = true;
    L156:
        r51 = false;
        goto L157
    L125:
        if (r45.isEmpty() == true) goto L128;
        r46 = false;
        goto L129
    L119:
        if (o0.d(r17.getConfirmNlg()) == false) goto L121;
        r124 = true;
        goto L122
    L166:
        e1.o(getBinding().j);
        getBinding().j.setOnLongClickListener(null);
        goto L167
    L92:
        r120 = false;
    L94:
        Object r53 = CollectionsKt.lastOrNull(r115.c);
        if (r53 != null) goto L97;
    L107:
        Boolean r54 = Boolean.FALSE;
        Integer r128 = Integer.valueOf(r115.c.size());
        if (r115.c.size() <= r115.e) goto L110;
        boolean r129 = true;
    L111:
        r121 = new Triple(r54, r128, Boolean.valueOf(r129));
        goto L112
    L110:
        r129 = false;
        goto L111
    L97:
        if ((r53 instanceof mca.e) == false) goto L107;
        Boolean r130 = Boolean.FALSE;
        mca.e r55 = (mca.e) r53;
        int r131 = r55.b;
        List r56 = ((ContactEntity) r55.a).getTelephones();
        if (r56 == null) goto L101;
        int r57 = r56.size();
    L102:
        Integer r58 = Integer.valueOf(r131 + r57);
        if (r115.c.size() <= r115.e) goto L105;
        boolean r132 = true;
    L106:
        r121 = new Triple(r130, r58, Boolean.valueOf(r132));
        goto L112
    L105:
        r132 = false;
        goto L106
    L101:
        r57 = 0;
        goto L102
    L79:
        if (Intrinsics.areEqual(r18.getBizContentType(), OAppIntentBizContentType.EVENT_TASK_CARD) == false) goto L82;
        r113 = 2;
        goto L85
    L82:
        if (Intrinsics.areEqual(r18.getBizContentType(), OAppIntentBizContentType.MUSIC_CARD) == false) goto L84;
        r113 = 4;
        goto L85
    L84:
        r113 = 5;
        goto L85
    L74:
        r22 = false;
        goto L76
    L41:
        if (r14.isEmpty() == true) goto L49;
        Iterator r59 = r14.iterator();
    L45:
        if (r59.hasNext() == false) goto L49;
        if ((r59.next() instanceof ContactEntity) == true) goto L45;
        boolean r60 = false;
    L50:
        if (r60 == false) goto L66;
        LinkedHashSet r61 = new LinkedHashSet();
        Iterator r133 = r14.iterator();
    L54:
        if (r133.hasNext() == false) goto L63;
        Object r134 = r133.next();
        if ((r134 instanceof ContactEntity) == true) goto L58;
    L60:
        boolean r135 = false;
    L61:
        if (r135 == false) goto L54;
    L64:
        if (r134 == null) goto L66;
        r21 = true;
        goto L67
    L58:
        if (r61.add(((ContactEntity) r134).getId()) == true) goto L60;
        r135 = true;
        goto L61
    L63:
        r134 = null;
    L49:
        r60 = true;
        goto L50
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(String r5, Integer r6, String r7) {
        PackageManager r2 = getContext().getPackageManager();     // Catch: Exception -> L10
        Drawable r3 = r2.getApplicationInfo(r5, 0).loadIcon(r2);     // Catch: Exception -> L10
        if (r3 != null) goto L8;
        FLogger.a.e("HybridAppEntityBox", "setIconFromPackage loadIcon returned null, packageName=".concat(r5));     // Catch: Exception -> L10
        if (r6 == null) goto L16;
        getBinding().d.setImageResource(r6.intValue());     // Catch: Exception -> L10
    L16:
        return;
    L8:
        getBinding().d.setImageDrawable(C(r3));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        if (r6 == null) goto L13;
        getBinding().d.setImageResource(r6.intValue());
    L13:
        if (r7 == null) goto L20;
        FLogger.a.e("HybridAppEntityBox", r7 + ": " + e);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(String r2, Integer r3, final Function0<Unit> r4, Function0<Unit> r5) {
        getBinding().b.setText(r2);
        TextView r6 = getBinding().b;
        Context r0 = getContext();
        if (r3 == null) goto L5;
        int r7 = r3.intValue();
    L6:
        r6.setTextColor(ContextCompat.getColor(r0, r7));
        e1.o(getBinding().h);
        e1.x(getBinding().d);
        e1.x(getBinding().b);
        getBinding().i.setOnClickListener(null);
        r5.invoke();
        if (r4 == null) goto L10;
        e1.d(getBinding().i, new q(r4));
        return;
    L10:
        return;
    L5:
        r7 = 2131103684;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void B(b0 r1, String r2, Function0 r3, Function0 r4, int r5) {
        if ((r5 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r1.z(r2, null, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Unit s(boolean r2, b0 r3, Message r4, AppEntityListAdapter r5, LinearLayout r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        if (r2 == false) goto L5;
        r3.y.add(r4.getLocalMessageId());
        r5.e = Integer.MAX_VALUE;
        r5.notifyDataSetChanged();
        e1.o(r3.getBinding().j);
    L38:
        return Unit.INSTANCE;
    L5:
        r3.getClass();
        xca.b.a.getClass();
        AppIntentMessage r7 = xca.b.a.a(r4);
        if (r7 == null) goto L44;
        Context r8 = r3.getContext();
    L9:
        FragmentActivity r9 = null;
        if (r8 == null) goto L21;
        if ((r8 instanceof FragmentActivity) == true) goto L13;
        if ((r8 instanceof ContextWrapper) == false) goto L17;
        ContextWrapper r10 = (ContextWrapper) r8;
    L18:
        if (r10 == null) goto L21;
        r8 = r10.getBaseContext();
        if (r8 != null) goto L9;
    L17:
        r10 = null;
        goto L18
    L13:
        r9 = (FragmentActivity) r8;
    L21:
        if (r9 != null) goto L23;
        FLogger.a.e("HybridAppEntityBox", "viewAll click: can't find FragmentActivity from context");
        return Unit.INSTANCE;
    L23:
        Bundle r11 = new Bundle();
        if (r7.getDataV2() == null) goto L29;
        List r1 = r7.getDataV2();
        if (r1 != null) goto L28;
        r1 = CollectionsKt.emptyList();
    L28:
        r11.putParcelableArrayList("dataV2", new ArrayList(r1));
    L33:
        r11.putParcelable("message_extra", com.obric.assistant.card.utils.c.a(r7, r4));
        r11.putBundle("trace_info", new Bundle(r3.getTraceInfo()));
        if (u(r7) == false) goto L36;
        r11.putInt("title", 2131912007);
    L36:
        int r12 = ShowAllDialogFragment.n;
        ShowAllDialogFragment.a.a(r9.getSupportFragmentManager(), r11);
        goto L38
    L29:
        Collection r13 = r7.getData();
        if (r13 != null) goto L32;
        r13 = CollectionsKt.emptyList();
    L32:
        r11.putParcelableArrayList(LynxResourceModule.DATA_KEY, new ArrayList(r13));
        goto L33
    L44:
        return Unit.INSTANCE;
    }
}
