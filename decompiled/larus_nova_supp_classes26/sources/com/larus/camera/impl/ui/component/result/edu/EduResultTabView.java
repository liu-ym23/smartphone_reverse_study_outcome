package com.larus.camera.impl.ui.component.result.edu;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.tabs.TabLayout;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.camera.impl.utils.w;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/edu/EduResultTabView;", "Lcom/google/android/material/tabs/TabLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentState", "Lcom/larus/camera/impl/entity/EduResultTabState;", "renderedModes", "", "Lcom/larus/camera/impl/entity/EduResultMode;", "tabSelectedListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "tabNavigationReported", "", "suppressSelectionTracking", "bind", "", "viewModel", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "render", "state", "renderTabs", "getSwitchModeShowType", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduResultTabView extends TabLayout {
    public px8.b a;
    public List<? extends EduResultMode> b;
    public f c;
    public boolean d;
    public boolean e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EduResultMode.values().length];
            r0[EduResultMode.PHOTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[EduResultMode.SINGLE_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[EduResultMode.MULTI_QUESTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[EduResultMode.HOMEWORK_CORRECTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public EduResultTabView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public EduResultTabView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static String b(EduResultMode r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "picture_mode";
    L5:
        if (r2 != 2) goto L7;
        return "single_question_mode";
    L7:
        if (r2 != 3) goto L9;
        return "multi_question_mode";
    L9:
        if (r2 != 4) goto L12;
        return "check_mode";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(CameraResultViewModel r4, CoroutineScope r5) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "scope");
        if (w.a() == true) goto L6;
        setVisibility(8);
        return;
    L6:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r4.getEduResultTabState(), new EduResultTabView$bind$1(this, r4, null)), CoroutineScopeKt.plus(r5, Dispatchers.getMain()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EduResultTabView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        px8.b r5 = px8.b.e;
        this.a = px8.b.e;
        this.b = CollectionsKt.emptyList();
        setVisibility(8);
    }

    public /* synthetic */ EduResultTabView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
