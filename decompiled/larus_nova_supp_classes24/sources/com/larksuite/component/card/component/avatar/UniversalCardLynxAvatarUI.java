package com.larksuite.component.card.component.avatar;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import rkb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\b\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\"\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larksuite/component/card/component/avatar/UniversalCardLynxAvatarUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "mAvatarLoadListener", "com/larksuite/component/card/component/avatar/UniversalCardLynxAvatarUI$mAvatarLoadListener$1", "Lcom/larksuite/component/card/component/avatar/UniversalCardLynxAvatarUI$mAvatarLoadListener$1;", "createView", "Landroid/content/Context;", "setContent", "", "props", "Lcom/lynx/react/bridge/ReadableMap;", "loadAvatar", "avatarKey", "", "userID", "size", "", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardLynxAvatarUI extends LynxUI<UDAvatar> {
    public static final /* synthetic */ int b = 0;
    public final b a;

    public static final class a {
    }

    public static final class b implements g<Object, Object> {
        public b() {
        }

        public final boolean onResourceReady(Object r1, Object r2, Target<Object> r3, DataSource r4, boolean r5) {
            return false;
        }

        public final boolean onLoadFailed(Exception r1, Object r2, Target<Object> r3, boolean r4) {
            if ((r2 instanceof AvatarImage) == false) goto L7;
            Log.e("UniversalCardLynxAvatarUI", "load avatar failed", r1);
            return false;
        L7:
            return false;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ UniversalCardLynxAvatarUI b;
        public final /* synthetic */ Ref.ObjectRef<AvatarProps> c;

        public static final class a implements Runnable {
            public final /* synthetic */ UniversalCardLynxAvatarUI a;
            public final /* synthetic */ Map<String, wy7.c> b;
            public final /* synthetic */ Ref.ObjectRef<AvatarProps> c;
            public final /* synthetic */ String d;

            public a(UniversalCardLynxAvatarUI r1, Map<String, wy7.c> r2, Ref.ObjectRef<AvatarProps> r3, String r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void a() {
                UniversalCardLynxAvatarUI r0 = this.a;
                wy7.c r1 = this.b.get(((AvatarProps) this.c.element).getPersonID());
                if (r1 == null) goto L5;
                String r2 = r1.a;
            L6:
                String r3 = this.d;
                int r4 = ((AvatarProps) this.c.element).getSize();
                int r5 = UniversalCardLynxAvatarUI.b;
                r0.M(r2, r3, r4);
                return;
            L5:
                r2 = null;
                goto L6
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(String r1, UniversalCardLynxAvatarUI r2, Ref.ObjectRef<AvatarProps> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            yy7.a r0 = ty7.a.a();     // Catch: Throwable -> L9
            if (r0 == null) goto L12;
            Map<String, wy7.c> r1 = r0.getChatterByIds(CollectionsKt.listOf(this.a));     // Catch: Throwable -> L9
            if (r1 == null) goto L16;
            mz7.b.a(new a(this.b, r1, this.c, this.a));     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    static {
    }

    public UniversalCardLynxAvatarUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new b();
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new UDAvatar(r2);
    }

    @LynxProp(name = "props")
    public final void setContent(ReadableMap r8) {
        TraceEvent.beginSection("UniversalCardLynxAvatarUI.setContent");
        if (r8 != null) goto L6;
        Log.i("UniversalCardLynxAvatarUI", "props null");
        return;
    L6:
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        Gson r3 = com.larksuite.component.card.component.g.a;     // Catch: Throwable -> L9
        r2.element = com.larksuite.component.card.component.g.c(r8, AvatarProps.class);     // Catch: Throwable -> L9
    L11:
        Object r9 = r2.element;
        if (r9 != null) goto L15;
        Log.e("UniversalCardLynxAvatarUI", "setContent fail, content is empty");
        return;
    L15:
        String r10 = ((AvatarProps) r9).getPersonID();
        String r4 = ((AvatarProps) r2.element).getAvatarKey();
        boolean r5 = true;
        if (r10 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == false) goto L24;
        Log.i("UniversalCardLynxAvatarUI", "userId is empty");
        ((UDAvatar) getView()).setImageDrawable(UIHelper.getDrawable(2131232484));
    L32:
        TraceEvent.endSection("UniversalCardLynxAvatarUI.setContent");
        return;
    L24:
        if (r4 != null) goto L26;
    L29:
        if (r5 == false) goto L31;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new c(r10, this, r2));
        goto L32
    L31:
        M(r4, r10, ((AvatarProps) r2.element).getSize());
        goto L32
    L26:
        if (r4.length() == 0) goto L29;
        r5 = false;
        goto L29
    L18:
        if (r10.length() == 0) goto L21;
        r6 = false;
    L9:
        th = move-exception;
        Log.e("UniversalCardLynxAvatarUI", "props from lynx transform failed", th);
        goto L11
    }

    public final void M(String r1, String r2, int r3) {
        int r4 = UIHelper.dp2px(r3);
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        ImageLoader.with(((UDAvatar) getView()).getContext()).load(AvatarImage.Builder.obtain(r1, r2, r4, r4).build()).listener(this.a).error(2131232484).setErrorScaleType(ImageView.ScaleType.CENTER_CROP).into((ImageView) getView());
    }
}
