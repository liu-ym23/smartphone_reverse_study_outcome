package com.bytedance.ai.ex.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.f2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a(\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/ViewGroup;", "viewGroup", "findFirstViewOfType", "(Landroid/view/ViewGroup;)Landroid/view/View;", "Ljava/lang/Class;", "clazz", "findFirstViewOfTypeInternal", "(Landroid/view/ViewGroup;Ljava/lang/Class;)Landroid/view/View;", "Lkotlinx/coroutines/flow/g;", "Lkotlin/time/Duration;", "period", "throttleLatest-HG0u8IE", "(Lkotlinx/coroutines/flow/g;J)Lkotlinx/coroutines/flow/g;", "throttleLatest", "widget-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetView.kt\ncom/bytedance/ai/ex/widget/WidgetViewKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,445:1\n1#2:446\n*E\n"})
public final class WidgetViewKt {
    public static final /* synthetic */ <T extends View> T findFirstViewOfType(ViewGroup r5) {
        if (r5 == null) goto L4;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) findFirstViewOfTypeInternal(r5, View.class);
    L4:
        return null;
    }

    public static final <T extends View> T findFirstViewOfTypeInternal(ViewGroup r5, Class<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        Intrinsics.checkNotNullParameter(r10, "clazz");
        int r11 = r5.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L14;
        View r13 = r5.getChildAt(r12);
        if (r10.isInstance(r13) == true) goto L7;
        if ((r13 instanceof ViewGroup) == false) goto L13;
        T r14 = (T) findFirstViewOfTypeInternal((ViewGroup) r13, r10);
        if (r14 == null) goto L13;
        return r14;
    L13:
        r12 = r12 + 1;
        goto L3
    L7:
        return r10.cast(r13);
    L14:
        return null;
    }

    /* JADX INFO: renamed from: throttleLatest-HG0u8IE, reason: not valid java name */
    public static final <T> kotlinx.coroutines.flow.g m86throttleLatestHG0u8IE(kotlinx.coroutines.flow.g r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$throttleLatest");
        return new f2(new WidgetViewKt$throttleLatest$1(r5, r10, null));
    }
}
