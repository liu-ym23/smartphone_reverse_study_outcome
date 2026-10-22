package androidx.core.os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
interface LocaleListInterface {
    Locale get(int r10);

    @Nullable
    Locale getFirstMatch(@NonNull String[] r10);

    Object getLocaleList();

    @IntRange(from = -1)
    int indexOf(Locale r10);

    boolean isEmpty();

    @IntRange(from = 0)
    int size();

    String toLanguageTags();
}
