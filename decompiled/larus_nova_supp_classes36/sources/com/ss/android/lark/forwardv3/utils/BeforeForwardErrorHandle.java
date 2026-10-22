package com.ss.android.lark.forwardv3.utils;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class BeforeForwardErrorHandle {
    public final Context a;
    public final Lazy b;
    public final CopyOnWriteArrayList<d> c;

    public static final class a {
    }

    public static final class b implements d {
        public final Context a;

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final boolean a(int r2) {
            if (r2 != 260008) goto L5;
        L8:
            return true;
        L5:
            if (r2 == 260009) goto L8;
            return false;
        }

        public final Context getContext() {
            return this.a;
        }

        public b(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final void b(String r3) {
            Log.i("BeforeForwardHandle", "forward before forward failed: external permission invalid");
            if (r3 != null) goto L5;
            r3 = UIUtils.getString(this.a, 2131890555);
        L5:
            Context r0 = this.a;
            Intrinsics.checkNotNull(r3);
            UDToast.show(r0, r3);
        }
    }

    public static final class c implements d {
        public c() {
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final boolean a(int r2) {
            if (r2 != 4052) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final void b(String r3) {
            Log.e("BeforeForwardHandle", "forward before forward failed: no im permission");
            ForwardModuleV3.a().showNoIMPermissionDialog(r3);
        }
    }

    public interface d {
        boolean a(int r1);

        void b(String r1);
    }

    public static final class e implements d {
        public e() {
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final boolean a(int r2) {
            if (260000 <= r2) goto L5;
        L7:
            return false;
        L5:
            if (r2 > 260007) goto L7;
            return true;
        }

        @Override // com.ss.android.lark.forwardv3.utils.BeforeForwardErrorHandle.d
        public final void b(String r2) {
            Log.i("BeforeForwardHandle", "forward before forward failed: contact invalid");
        }
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public BeforeForwardErrorHandle(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        this.b = LazyKt.lazy(new BeforeForwardErrorHandle$scope$2(this));
        CopyOnWriteArrayList<d> r0 = new CopyOnWriteArrayList();
        r0.add(new c());
        r0.add(new e());
        r0.add(new b(r3));
        this.c = r0;
    }

    public final void a(int r9, String r10, Function0 r11) {
        if (((CoroutineScope) this.b.getValue()) != null) goto L6;
        Log.e("BeforeForwardHandle", "life scope is null");
        return;
    L6:
        Iterator<d> r0 = this.c.iterator();
    L8:
        if (r0.hasNext() == false) goto L15;
        d r1 = r0.next();
        if (r1.a(r9) == false) goto L8;
        CoroutineScope r2 = (CoroutineScope) this.b.getValue();
        if (r2 == null) goto L20;
        BuildersKt.launch$default(r2, null, null, new BeforeForwardErrorHandle$handle$2$1(r1, r10, null), 3, null);
        return;
    L20:
        return;
    L15:
        ((Boolean) r11.invoke()).booleanValue();
    }
}
