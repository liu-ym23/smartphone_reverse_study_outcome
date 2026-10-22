package jw8;

import android.text.Spanned;
import android.widget.TextView;
import lw8.d;
import tsc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface b extends o {
    void a(TextView r1);

    void b(TextView r1, Spanned r2, d r3);

    void e(TextView r1, boolean r2);

    String getCode();

    Integer getEndIndex();

    String getLanguage();

    Integer getStartIndex();

    void m(Spanned r1, b r2);
}
