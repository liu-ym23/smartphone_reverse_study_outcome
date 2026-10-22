package androidx.viewpager2.adapter;

import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface StatefulAdapter {
    void restoreState(@NonNull Parcelable r10);

    @NonNull
    Parcelable saveState();
}
