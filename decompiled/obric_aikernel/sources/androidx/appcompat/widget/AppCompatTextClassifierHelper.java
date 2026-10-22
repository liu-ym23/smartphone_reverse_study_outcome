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
    private static final class Api26Impl {
        private Api26Impl() {
        }

        @NonNull
        @DoNotInline
        static TextClassifier getTextClassifier(@NonNull TextView r10) {
            TextClassificationManager r11 = (TextClassificationManager) r10.getContext().getSystemService(TextClassificationManager.class);
            if (r11 == null) goto L7;
            return r11.getTextClassifier();
        L7:
            return TextClassifier.NO_OP;
        }
    }

    AppCompatTextClassifierHelper(@NonNull TextView r10) {
        this.mTextView = (TextView) Preconditions.checkNotNull(r10);
    }

    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        TextClassifier r10 = this.mTextClassifier;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Api26Impl.getTextClassifier(this.mTextView);
    }

    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier r10) {
        this.mTextClassifier = r10;
    }
}
