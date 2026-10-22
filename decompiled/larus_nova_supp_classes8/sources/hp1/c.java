package hp1;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements jp1.b {
    public final x3 a;
    public final DataCenter b;
    public final WeakReference<b2> c;
    public final a d;

    public static final class a {
        public static final C0389a e = null;
        public x3 a;
        public Function1<? super Integer, ? extends View> b;
        public b2 c;
        public final DataCenter d;

        /* JADX INFO: renamed from: hp1.c$a$a, reason: collision with other inner class name */
        public static final class C0389a {
            public C0389a() {
            }
        }

        static {
            e = new C0389a();
        }

        public a(DataCenter r1) {
            this.d = r1;
        }
    }

    @Override // jp1.b
    public final RoomContext a() {
        return RoomContext.a.c(RoomContext.Companion, this.b, 0, 2);
    }

    @Override // jp1.b
    public final ViewModel b() {
        MorePanelDynamicControllerViewModel.Companion r0 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r1 = this.b;
        r0.getClass();
        return MorePanelDynamicControllerViewModel.Companion.a(r1);
    }

    @Override // jp1.b
    public final WeakReference<b2> c() {
        return this.c;
    }

    @Override // jp1.b
    public final DataCenter getDataCenter() {
        return this.b;
    }

    @Override // jp1.b
    public final x3 getToolbarManager() {
        return this.a;
    }

    public c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.d = r2;
        this.a = r2.a;
        this.b = r2.d;
        b2 r3 = r2.c;
        if (r3 == null) goto L5;
        WeakReference<b2> r0 = new WeakReference(r3);
    L6:
        this.c = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // jp1.b
    public final <V extends View> V findView(int r3) {
        Function1<? super Integer, ? extends View> r0 = this.d.b;
        if (r0 == null) goto L5;
        View r4 = (View) r0.invoke(Integer.valueOf(r3));
    L7:
        if ((r4 instanceof View) == true) goto L10;
        return null;
    L10:
        return (V) r4;
    L5:
        r4 = null;
        goto L7
    }
}
