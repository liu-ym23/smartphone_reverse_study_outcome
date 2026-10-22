package com.obric.memorydata.memory.ui.automemory;

import android.app.Activity;
import com.obric.memorydata.memory.ui.feedback.MemoryFeedbackScene;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0018\u00010\u000bJG\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0018\u00010\u000b2\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u0000¢\u0006\u0002\b\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryFeedbackDialog;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "show", "", "extraText", "", "customFilePathListProvider", "Lkotlin/Function1;", "", "odpReportDataProvider", "Lkotlin/Function0;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportData;", "show$memory_obricRelease", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f10675a;

    public h(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.f10675a = ZeusTransformUtils.wrapperContext2Activity(r4, "com.obric.memorydata.plugin");
    }

    public final void a(String r3, Function1<? super String, ? extends List<String>> r4, Function0<com.obric.memorydata.memory.ui.feedback.h> r5) {
        Function1<? super String, ? extends List<String>> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function0<com.obric.memorydata.memory.ui.feedback.h> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        new com.obric.memorydata.memory.ui.feedback.f(this.f10675a).a(MemoryFeedbackScene.AUTO_MEMORY_PRO, r3, r6, r7);
    }
}
