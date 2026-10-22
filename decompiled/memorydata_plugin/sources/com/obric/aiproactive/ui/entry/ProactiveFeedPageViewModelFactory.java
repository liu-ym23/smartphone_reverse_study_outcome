package com.obric.aiproactive.ui.entry;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiproactive/ui/entry/ProactiveFeedPageViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "appContext", "Landroid/content/Context;", "repository", "Lcom/obric/aiproactive/ui/data/ProactiveRepository;", "timeProvider", "Lcom/obric/aiproactive/ui/model/TimeProvider;", "<init>", "(Landroid/content/Context;Lcom/obric/aiproactive/ui/data/ProactiveRepository;Lcom/obric/aiproactive/ui/model/TimeProvider;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveFeedPageViewModelFactory implements ViewModelProvider.Factory {
    private final Context appContext;
    private final com.obric.aiproactive.ui.data.b repository;
    private final com.obric.aiproactive.ui.model.m timeProvider;

    public ProactiveFeedPageViewModelFactory(Context r3, com.obric.aiproactive.ui.data.b r4, com.obric.aiproactive.ui.model.m r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.data.b r7 = (com.obric.aiproactive.ui.data.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiproactive.ui.data.b.class, "com.obric.memorydata.plugin");
        com.obric.aiproactive.ui.model.m r8 = (com.obric.aiproactive.ui.model.m) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiproactive.ui.model.m.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "appContext");
        Intrinsics.checkNotNullParameter(r7, "repository");
        Intrinsics.checkNotNullParameter(r8, "timeProvider");
        this.appContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.repository = r7;
        this.timeProvider = r8;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> r6) {
        Intrinsics.checkNotNullParameter(r6, "modelClass");
        com.obric.aiproactive.ui.feedback.g r0 = new com.obric.aiproactive.ui.feedback.g(this.appContext);
        if (r6.isAssignableFrom(NowFeedViewModel.class) == false) goto L7;
        Object r7 = new NowFeedViewModel(this.repository, this.timeProvider, r0);
    L9:
        return (T) ZeusTransformUtils.preCheckCast(r7, ViewModel.class, "com.obric.memorydata.plugin");
    L7:
        if (r6.isAssignableFrom(AllFeedViewModel.class) == false) goto L11;
        r7 = new AllFeedViewModel(this.repository, this.timeProvider, new com.obric.aiproactive.ui.feedback.h(this.appContext), r0);
        goto L9
    L11:
        throw new IllegalArgumentException("Unknown ViewModel class: " + r6.getName());
    }
}
