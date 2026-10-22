package kotlin.jvm.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/jvm/internal/FloatSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", EventBody.KEY_VALUE, "", "toArray", "getSize", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FloatSpreadBuilder extends PrimitiveSpreadBuilder<float[]> {
    private final float[] values;

    public FloatSpreadBuilder(int r1) {
        super(r1);
        this.values = new float[r1];
    }

    public final void add(float r4) {
        float[] r0 = this.values;
        int r1 = getPosition();
        setPosition(r1 + 1);
        r0[r1] = r4;
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public /* synthetic */ int getSize(float[] r3) {
        return getSize2((float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: getSize, reason: avoid collision after fix types in other method */
    public int getSize2(float[] r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.length;
    }

    public final float[] toArray() {
        return (float[]) ZeusTransformUtils.preCheckCast(toArray(this.values, new float[size()]), float[].class, "com.obric.memorydata.plugin");
    }
}
