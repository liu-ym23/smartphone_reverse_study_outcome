package androidx.core.content;

import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\b¨\u0006\t"}, d2 = {"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SharedPreferencesKt {
    public static final void edit(SharedPreferences r2, boolean r3, Function1<? super SharedPreferences.Editor, Unit> r4) {
        SharedPreferences r5 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        SharedPreferences.Editor r7 = r5.edit();
        r6.invoke(r7);
        if (r3 == false) goto L5;
        r7.commit();
        return;
    L5:
        r7.apply();
    }

    public static /* synthetic */ void edit$default(SharedPreferences r1, boolean r2, Function1 r3, int r4, Object r5) {
        SharedPreferences r6 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r1, SharedPreferences.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = false;
    L5:
        SharedPreferences.Editor r8 = r6.edit();
        r7.invoke(r8);
        if (r2 == false) goto L8;
        r8.commit();
        return;
    L8:
        r8.apply();
    }
}
