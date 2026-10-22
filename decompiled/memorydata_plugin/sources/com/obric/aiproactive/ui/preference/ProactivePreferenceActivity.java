package com.obric.aiproactive.ui.preference;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.obric.aiproactive.api.AiProactivePreferenceExampleDto;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.ui.databinding.ActivityProactivePreferenceBinding;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/preference/ProactivePreferenceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/obric/aiproactive/ui/databinding/ActivityProactivePreferenceBinding;", "proactiveService", "Lcom/obric/aiproactive/api/IProactiveService;", "kotlin.jvm.PlatformType", "getProactiveService", "()Lcom/obric/aiproactive/api/IProactiveService;", "proactiveService$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "loadData", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactivePreferenceActivity extends AppCompatActivity {
    private ActivityProactivePreferenceBinding binding;
    private final Lazy proactiveService$delegate;

    public ProactivePreferenceActivity() {
        this.proactiveService$delegate = LazyKt.lazy($$Lambda$ProactivePreferenceActivity$dhC794EE8AGhBXbV2Nw8Ey_2_0.INSTANCE);
    }

    private final IProactiveService getProactiveService() {
        return (IProactiveService) ZeusTransformUtils.preCheckCast(this.proactiveService$delegate.getValue(), IProactiveService.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$dhC794EE8AGhBXbV2Nw8Ey_2-_0, reason: not valid java name */
    public static /* synthetic */ IProactiveService m329lambda$dhC794EE8AGhBXbV2Nw8Ey_2_0() {
        return proactiveService_delegate$lambda$0();
    }

    private final void loadData() {
        IProactiveService r0 = getProactiveService();
        if (r0 == null) goto L6;
        List<AiProactivePreferenceExampleDto> r1 = r0.getProactivePreferenceExamples();
        if (r1 == null) goto L6;
    L7:
        q r2 = new q(r1);
        ActivityProactivePreferenceBinding r3 = this.binding;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L10:
        r3.rvPreferences.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r2, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        r1 = CollectionsKt.emptyList();
        goto L7
    }

    private static final IProactiveService proactiveService_delegate$lambda$0() {
        return (IProactiveService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IProactiveService.class), IProactiveService.class, "com.obric.memorydata.plugin");
    }

    private final void setupRecyclerView() {
        ActivityProactivePreferenceBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.rvPreferences.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        ActivityProactivePreferenceBinding r6 = ActivityProactivePreferenceBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        Window r7 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r7, "getWindow(...)");
        com.obric.memorydata.ui.g.a(r7, NavigationBarScheme.B1);
        ActivityProactivePreferenceBinding r8 = this.binding;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L8:
        RecyclerView r9 = r8.rvPreferences;
        Intrinsics.checkNotNullExpressionValue(r9, "rvPreferences");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        setupRecyclerView();
        loadData();
    }
}
