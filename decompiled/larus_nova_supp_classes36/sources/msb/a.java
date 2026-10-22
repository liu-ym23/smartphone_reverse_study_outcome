package msb;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.multitask.task.b;
import com.ss.android.lark.multitask.task.e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: msb.a$a, reason: collision with other inner class name */
    public static final class C0299a {
    }

    static {
    }

    public final e b() {
        Intrinsics.throwUninitializedPropertyAccessException("taskWrapper");
        return null;
    }

    public final void c() {
        Log.i("MULTITASK-MultitaskHelper", "isDuplicatedTask isInitialized = false");
    }

    public final void e() {
        Log.i("MULTITASK-MultitaskHelper", "terminate isInitialized = false");
    }

    public a() {
        Log.e("MULTITASK-MultitaskHelper", "Multitask is not initialized. Skip initialization!");
    }

    @JvmStatic
    public static final a a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "taskWrapper");
        Intrinsics.checkNotNullParameter(r2, "taskWrapper");
        return new a(r2, true);
    }

    public static a d(b r2) {
        Intrinsics.checkNotNullParameter(r2, "taskWrapper");
        Fragment r0 = r2.getActivity().getSupportFragmentManager().findFragmentByTag("multitask.lifecycle.fragment.tag");
        if (r0 == null) goto L6;
        r2.getActivity().getSupportFragmentManager().beginTransaction().remove(r0).commitNowAllowingStateLoss();
    L6:
        return new a();
    }

    public a(b r1, boolean r2) {
        if (r2 == false) goto L5;
        new com.ss.android.lark.slideback.b(r1.getActivity());
    L5:
        Log.e("MULTITASK-MultitaskHelper", "Multitask is not initialized. Skip initialization!");
    }
}
