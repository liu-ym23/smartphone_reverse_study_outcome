package androidx.activity;

import android.graphics.Color;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u000b\u001a\u00020\f*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0011\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DefaultDarkScrim", "", "getDefaultDarkScrim$annotations", "()V", "getDefaultDarkScrim", "()I", "DefaultLightScrim", "getDefaultLightScrim$annotations", "getDefaultLightScrim", "Impl", "Landroidx/activity/EdgeToEdgeImpl;", "enableEdgeToEdge", "", "Landroidx/activity/ComponentActivity;", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "enable", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@JvmName(name = "EdgeToEdge")
@SourceDebugExtension({"SMAP\nEdgeToEdge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EdgeToEdge.kt\nandroidx/activity/EdgeToEdge\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,301:1\n1#2:302\n*E\n"})
public final class EdgeToEdge {
    private static final int DefaultDarkScrim = 0;
    private static final int DefaultLightScrim = 0;
    private static EdgeToEdgeImpl Impl;

    static {
        DefaultLightScrim = Color.argb(230, 255, 255, 255);
        DefaultDarkScrim = Color.argb(128, 27, 27, 27);
    }

    @JvmOverloads
    @JvmName(name = "enable")
    public static final void enable(ComponentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        enable$default(r5, null, null, 3, null);
    }

    public static /* synthetic */ void enable$default(ComponentActivity r10, SystemBarStyle r11, SystemBarStyle r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, null, 4, null);
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
    L8:
        enable(r10, r11, r12);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    @JvmOverloads
    @JvmName(name = "enable")
    public static final void enable(ComponentActivity r5, SystemBarStyle r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "statusBarStyle");
        enable$default(r5, r10, null, 2, null);
    }

    @JvmOverloads
    @JvmName(name = "enable")
    public static final void enable(ComponentActivity r10, SystemBarStyle r11, SystemBarStyle r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "statusBarStyle");
        Intrinsics.checkNotNullParameter(r12, "navigationBarStyle");
        View r5 = r10.getWindow().getDecorView();
        boolean r13 = r11.getDetectDarkMode$activity_release().invoke(r5.getResources()).booleanValue();
        boolean r14 = r12.getDetectDarkMode$activity_release().invoke(r5.getResources()).booleanValue();
        EdgeToEdgeImpl r15 = Impl;
        if (r15 != null) goto L5;
        r15 = new EdgeToEdgeApi29();
    L5:
        r15.setUp(r11, r12, r10.getWindow(), r5, r13, r14);
    }
}
