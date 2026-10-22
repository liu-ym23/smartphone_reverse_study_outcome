package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatTextClassifierHelper {

    @Nullable
    private TextClassifier mTextClassifier;

    @NonNull
    private TextView mTextView;

    @RequiresApi(26)
    public static final class Api26Impl {
        private Api26Impl() {
        }

        @NonNull
        @DoNotInline
        public static TextClassifier getTextClassifier(@NonNull TextView r5) {
            TextClassificationManager r10 = (TextClassificationManager) r5.getContext().getSystemService(TextClassificationManager.class);
            if (r10 == null) goto L7;
            return r10.getTextClassifier();
        L7:
            return TextClassifier.NO_OP;
        }
    }

    public AppCompatTextClassifierHelper(@NonNull TextView r5) {
        this.mTextView = (TextView) Preconditions.checkNotNull(r5);
    }

    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        TextClassifier r5 = this.mTextClassifier;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return Api26Impl.getTextClassifier(this.mTextView);
    }

    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier r5) {
        this.mTextClassifier = r5;
    }
}
