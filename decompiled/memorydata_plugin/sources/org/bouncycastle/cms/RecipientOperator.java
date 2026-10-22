package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.operator.InputAEADDecryptor;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.util.io.TeeInputStream;

/* JADX INFO: loaded from: classes7.dex */
public class RecipientOperator {
    private final Object operator;

    public RecipientOperator(InputDecryptor r3) {
        this.operator = (InputDecryptor) ZeusTransformUtils.wrapperContextForParams(r3, InputDecryptor.class, "com.obric.memorydata.plugin");
    }

    public OutputStream getAADStream() {
        return ((InputAEADDecryptor) ZeusTransformUtils.preCheckCast(this.operator, InputAEADDecryptor.class, "com.obric.memorydata.plugin")).getAADStream();
    }

    public InputStream getInputStream(InputStream r4) {
        if (ZeusTransformUtils.instanceOf(this.operator, InputDecryptor.class) == false) goto L7;
        return ((InputDecryptor) ZeusTransformUtils.preCheckCast(this.operator, InputDecryptor.class, "com.obric.memorydata.plugin")).getInputStream(r4);
    L7:
        return new TeeInputStream(r4, ((MacCalculator) ZeusTransformUtils.preCheckCast(this.operator, MacCalculator.class, "com.obric.memorydata.plugin")).getOutputStream());
    }
}
