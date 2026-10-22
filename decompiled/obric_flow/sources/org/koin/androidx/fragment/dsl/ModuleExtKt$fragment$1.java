package org.koin.androidx.fragment.dsl;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.koin.core.scope.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/fragment/app/Fragment;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/koin/core/scope/a;", "Lvu/a;", ST.IMPLICIT_ARG_NAME, "invoke", "(Lorg/koin/core/scope/a;Lvu/a;)Landroidx/fragment/app/Fragment;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nModuleExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleExt.kt\norg/koin/androidx/fragment/dsl/ModuleExtKt$fragment$1\n+ 2 InstanceBuilder.kt\norg/koin/core/instance/InstanceBuilderKt\n*L\n1#1,45:1\n19#2:46\n*S KotlinDebug\n*F\n+ 1 ModuleExt.kt\norg/koin/androidx/fragment/dsl/ModuleExtKt$fragment$1\n*L\n44#1:46\n*E\n"})
public final class ModuleExtKt$fragment$1 extends Lambda implements Function2<a, vu.a, Fragment> {
    public static final ModuleExtKt$fragment$1 INSTANCE = null;

    static {
        Intrinsics.needClassReification();
        INSTANCE = new ModuleExtKt$fragment$1();
    }

    public ModuleExtKt$fragment$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Fragment mo2invoke(a r5, vu.a r10) {
        return invoke2(r5, r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Fragment invoke2(a r5, vu.a r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$factory");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (Fragment) org.koin.core.instance.a.b(r5, Reflection.getOrCreateKotlinClass(Object.class), r10);
    }
}
