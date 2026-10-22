package com.bytedance.forest.postprocessor;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.forest.model.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/forest/model/w;", ST.IMPLICIT_ARG_NAME, "", "invoke", "(Lcom/bytedance/forest/model/w;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ResourceProcessChain$process$1 extends Lambda implements Function1<w, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f4546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lambda f4547b;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceProcessChain$process$1(h r5, Function1 r10) {
        this.f4546a = r5;
        this.f4547b = (Lambda) r10;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(w r5) {
        this.f4546a.f4555c.b(new String[]{"post_processor_execute_finish"});
        ?? r10 = this.f4547b;
        r10.invoke(r5);
        return Unit.INSTANCE;
    }
}
