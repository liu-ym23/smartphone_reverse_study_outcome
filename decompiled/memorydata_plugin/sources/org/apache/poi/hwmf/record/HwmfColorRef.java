package org.apache.poi.hwmf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfColorRef implements GenericRecord {
    private Color colorRef;

    public HwmfColorRef() {
        this.colorRef = Color.BLACK;
    }

    public HwmfColorRef(Color r3) {
        Color r4 = (Color) ZeusTransformUtils.wrapperContextForParams(r3, Color.class, "com.obric.memorydata.plugin");
        this.colorRef = Color.BLACK;
        this.colorRef = r4;
    }

    public HwmfColorRef(HwmfColorRef r2) {
        this.colorRef = Color.BLACK;
        this.colorRef = r2.colorRef;
    }

    public HwmfColorRef copy() {
        return new HwmfColorRef(this);
    }

    public Color getColor() {
        return this.colorRef;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(TypedValues.Custom.S_COLOR, new $$Lambda$prtqEKCSXZl3xXtfzFnH2asLyAs(this));
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
