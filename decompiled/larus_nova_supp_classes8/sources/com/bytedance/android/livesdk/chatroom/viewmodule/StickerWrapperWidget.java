package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.livesdk.chatroom.presenter.StickerPresenter;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationDetail;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u00020\u0005:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/StickerWrapperWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/livesdk/chatroom/presenter/StickerPresenter$IView;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/y0;", "<init>", "()V", "a", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class StickerWrapperWidget extends LiveWidget implements StickerPresenter.IView, Observer<KVData>, y0 {
    public static final /* synthetic */ int j = 0;
    public a a;
    public Function0<Void> b;
    public int[] c;
    public final int[] d;
    public final List<com.bytedance.android.livesdk.chatroom.widget.u> e;
    public boolean f;
    public StickerPresenter g;
    public String h;
    public Room i;

    public interface a {
    }

    public static final class b {
        public static boolean a(boolean r3) {
            if (r3 == false) goto L5;
            return true;
        L5:
            ILiveExpOptService r4 = jc1.k.f(ILiveExpOptService.class);
            if (r4 == null) goto L12;
            l61.c r5 = r4.getSceneState(null, l61.d.a.c.e);
            if (r5 == null) goto L12;
            if (r5.a() != true) goto L12;
            boolean r6 = true;
        L14:
            return !r6;
        L12:
            r6 = false;
            goto L14
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ StickerWrapperWidget a;
        public final /* synthetic */ DecorationDetail b;

        public c(StickerWrapperWidget r1, DecorationDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DecorationDetail r0 = this.b;     // Catch: Throwable -> L12
            if (r0 == null) goto L10;
            RoomDecoration r1 = r0.getTextDecoration();     // Catch: Throwable -> L12
            if (r1 == null) goto L7;
            this.a.wq(r1);     // Catch: Throwable -> L12
            this.a.Cq(r1);     // Catch: Throwable -> L12
        L7:
            RoomDecoration r2 = r0.getImageDecoration();     // Catch: Throwable -> L12
            if (r2 == null) goto L10;
            this.a.wq(r2);     // Catch: Throwable -> L12
            this.a.Cq(r2);     // Catch: Throwable -> L12
        L10:
            this.a.vd();     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L16;
            return;
        L16:
            throw th;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ StickerWrapperWidget a;

        public d(StickerWrapperWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            StickerWrapperWidget r0 = this.a;
            int r1 = StickerWrapperWidget.j;
            r0.getClass();
            int r4 = ((zg1.h1) r3).a;
            if (r4 != 30) goto L5;
            ((Widget) r0).contentView.setVisibility(8);
            return;
        L5:
            if (r4 != 31) goto L14;
            ((Widget) r0).contentView.setVisibility(0);
            if ((r0 instanceof AudienceStickerWrapperWidget) == false) goto L12;
            ((AudienceStickerWrapperWidget) r0).Jq();
            return;
        L12:
            return;
        }
    }

    static {
    }

    public void Aq(KVData r2) {
        Intrinsics.checkNotNullParameter(r2, "kvData");
    }

    public void Cq(RoomDecoration r2) {
        Intrinsics.checkNotNullParameter(r2, "decoration");
    }

    public com.bytedance.android.livesdk.chatroom.model.e3 Qn() {
        return null;
    }

    public boolean Z5(long r1) {
        return false;
    }

    public boolean fi(long r1) {
        return false;
    }

    public int getLayoutId() {
        return 2131568007;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    public void vd() {
    }

    public void ve() {
    }

    public void xq(RoomDecoration r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "roomDecoration");
    }

    public int zq(int r1) {
        return r1;
    }

    public final StickerPresenter yq() {
        StickerPresenter r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L5:
        return r0;
    }

    public StickerWrapperWidget() {
        this.c = new int[4];
        this.d = new int[4];
        this.e = new ArrayList();
        this.h = "0";
        this.i = new Room();
    }

    public void onCreate() {
        super.onCreate();
        String r2 = null;
        Object r0 = ((Widget) this).dataCenter.get("data_room", null);
        Intrinsics.checkNotNull(r0);
        this.i = (Room) r0;
        com.bytedance.android.live.core.utils.z.n(((Widget) this).dataCenter);
        User r1 = this.i.getOwner();
        if (r1 == null) goto L6;
        String r3 = r1.getIdStr();
        if (r3 == null) goto L6;
    L7:
        this.h = r3;
        L7(zg1.h1.class, new d(this));
        ((Widget) this).dataCenter.observeForever("cmd_pk_state_change", this).observeForever("data_keyboard_status_douyin", this);
        w3 r4 = v2.a;
        Intrinsics.checkNotNullParameter(this, "manager");
        com.bytedance.android.scope.m.e.getClass();
        w3 r5 = new w3(com.bytedance.android.scope.m.d);
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(this, "value");
        r5.e = this;
        if (this != e33.k.a) goto L10;
        r2 = "manager";
    L10:
        if (r2 != null) goto L14;
        v2.a = r5;
        com.bytedance.android.scope.l.a(r5);
        return;
    L14:
        throw new UninitializedPropertyAccessException(r2);
    L6:
        r3 = "0";
        goto L7
    }

    public void onDestroy() {
        super.onDestroy();
        w3 r0 = v2.a;
        if (r0 == null) goto L5;
        com.bytedance.android.scope.l.c(r0);
    L5:
        v2.a = null;
        ((Widget) this).dataCenter.removeObserver(this);
        yq().detachView();
    }

    public void OS(DecorationDetail r3) {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L6;
        r0.post(new c(this, r3));
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (isViewValid() == false) goto L39;
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5.getKey()) == false) goto L8;
        return;
    L8:
        if (r5.getData() == null) goto L46;
        String r0 = r5.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-1540323875)) goto L26;
        if (r1 == 294674590) goto L16;
    L36:
        Aq(r5);
        return;
    L16:
        if (r0.equals("data_keyboard_status_douyin") == false) goto L36;
        Object r6 = r5.getData();
        Intrinsics.checkNotNull(r6);
        boolean r7 = ((Boolean) r6).booleanValue();
        ViewGroup r2 = ((Widget) this).containerView;
        if (r7 == false) goto L20;
        int r3 = 8;
    L21:
        UIUtils.setViewVisibility(r2, r3);
        if ((this instanceof AudienceStickerWrapperWidget) == false) goto L42;
        if (r7 == false) goto L43;
        ((AudienceStickerWrapperWidget) this).Jq();
        return;
    L43:
        return;
    L42:
        return;
    L20:
        r3 = 0;
        goto L21
    L26:
        if (r0.equals("cmd_pk_state_change") == false) goto L36;
        zg1.z0 r8 = (zg1.z0) r5.getData();
        Intrinsics.checkNotNull(r8);
        int r9 = r8.a;
        if (r9 != 0) goto L30;
        oq2.d r10 = jc1.k.n(ILinkServiceExternal.class).getPkServiceExternal().G();
        this.c[1] = r10.a + r10.c;
    L32:
        Iterator r11 = ((ArrayList) this.e).iterator();
    L34:
        if (r11.hasNext() == false) goto L47;
        ((com.bytedance.android.livesdk.chatroom.widget.u) r11.next()).m(this.c);
        goto L34
    L47:
        return;
    L30:
        if (r9 != 1) goto L45;
        this.c = this.d;
        goto L32
    L45:
        return;
    L46:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.y0
    public final int wm(long r8) {
        Iterator r0 = ((ArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.android.livesdk.chatroom.widget.u) r1).getRoomDecoration().getId() != r8) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
    L13:
        if (((com.bytedance.android.livesdk.chatroom.widget.u) r1) == null) goto L21;
        return 1;
    L21:
        return 0;
    L8:
        r4 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public final void wq(RoomDecoration r8) {
        Intrinsics.checkNotNullParameter(r8, "roomDecoration");
        RoomSpecificSceneTypeInfo r0 = this.i.getSceneTypeInfo();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return;
    L11:
        if (isViewValid() == false) goto L24;
        if (r8 == null) goto L26;
        Bq(r8, true);
        if (isViewValid() == true) goto L17;
    L22:
        xq(r8, true);
        return;
    L17:
        if (((Widget) this).context == null) goto L22;
        if (this.f == true) goto L22;
        int[] r3 = new int[2];
        ((Widget) this).contentView.getLocationInWindow(r3);
        int r4 = (r3[1] + ((Widget) this).contentView.getHeight()) - com.bytedance.android.live.core.utils.s1.j(2131168549);
        int r5 = UIUtils.getScreenWidth(((Widget) this).context);
        int[] r6 = this.d;
        r6[0] = 0;
        r6[1] = r4;
        r6[2] = 0;
        r6[3] = r5;
        int r7 = zq(r4);
        int[] r9 = this.c;
        r9[0] = 0;
        r9[1] = r7;
        r9[2] = 0;
        r9[3] = r5;
        this.f = true;
        goto L22
    L26:
        return;
    L24:
        return;
    L5:
        if (r0.isLandscapeVertical() != true) goto L7;
        r1 = true;
        goto L8
    }

    public void Bq(RoomDecoration r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "decoration");
        if (isViewValid() == true) goto L5;
        return;
    L5:
        int r5 = ((ArrayList) this.e).size();
    L6:
        r5 = r5 - 1;
        if (r5 < 0) goto L15;
        if (((com.bytedance.android.livesdk.chatroom.widget.u) ListProtector.get(this.e, r5)).getType() != r3.getType()) goto L6;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L14;
        ((ViewGroup) r0).removeView((View) ListProtector.get(this.e, r5));
        ListProtector.remove(this.e, r5);
        goto L6
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final <T> void L7(Class<T> r2, Consumer<? super T> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).as(autoDispose())).subscribe(r3);
    }
}
