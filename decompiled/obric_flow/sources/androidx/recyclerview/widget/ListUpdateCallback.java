package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface ListUpdateCallback {
    void onChanged(int r5, int r10, @Nullable Object r11);

    void onInserted(int r5, int r10);

    void onMoved(int r5, int r10);

    void onRemoved(int r5, int r10);
}
