package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.CommonProcessorDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/room/compiler/processing/CommonProcessorDelegate;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KspBasicAnnotationProcessor$commonDelegate$2 extends Lambda implements Function0<CommonProcessorDelegate> {
    final /* synthetic */ KspBasicAnnotationProcessor this$0;

    public KspBasicAnnotationProcessor$commonDelegate$2(KspBasicAnnotationProcessor r5) {
        this.this$0 = r5;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CommonProcessorDelegate invoke() {
        return new CommonProcessorDelegate(this.this$0.getClass(), KspBasicAnnotationProcessor.access$getXEnv$p(this.this$0), KspBasicAnnotationProcessor.access$getSteps(this.this$0));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CommonProcessorDelegate invoke() {
        return invoke();
    }
}
