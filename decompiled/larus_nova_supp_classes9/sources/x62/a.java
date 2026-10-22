package x62;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.widget.TextView;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends qtc.a implements TextWatcher {
    public Observer<? super CharSequence> b;
    public final TextView c;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public final void b() {
        this.c.removeTextChangedListener(this);
    }

    public a(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        this.c = r2;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        Observer<? super CharSequence> r0 = this.b;
        if (r0 == null) goto L10;
        CharSequence r4 = r3;
        if (r3 != null) goto L8;
        r4 = BuildConfig.FLAVOR;
    L8:
        r0.onNext(new SpannableStringBuilder(r4));
        return;
    }
}
