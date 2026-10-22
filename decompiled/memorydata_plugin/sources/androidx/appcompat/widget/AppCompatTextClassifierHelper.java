package androidx.appcompat.widget;

import android.content.Context;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatTextClassifierHelper {
    private TextClassifier mTextClassifier;
    private TextView mTextView;

    private static final class Api26Impl {
        private Api26Impl() {
        }

        static TextClassifier getTextClassifier(TextView r2) {
            TextClassificationManager r3 = (TextClassificationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(TextClassificationManager.class), TextClassificationManager.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L7;
            return r3.getTextClassifier();
        L7:
            return TextClassifier.NO_OP;
        }
    }

    AppCompatTextClassifierHelper(TextView r3) {
        this.mTextView = (TextView) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3), TextView.class, "com.obric.memorydata.plugin");
    }

    public TextClassifier getTextClassifier() {
        TextClassifier r0 = this.mTextClassifier;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Api26Impl.getTextClassifier(this.mTextView);
    }

    public void setTextClassifier(TextClassifier r3) {
        this.mTextClassifier = (TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.memorydata.plugin");
    }
}
