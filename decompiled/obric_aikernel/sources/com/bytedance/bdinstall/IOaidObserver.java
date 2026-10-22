package com.bytedance.bdinstall;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface IOaidObserver {

    public static final class Oaid {

        @Nullable
        public final String id;
        public final boolean maySupport;

        public Oaid(@Nullable String r10, boolean r11) {
            this.id = r10;
            this.maySupport = r11;
        }

        public String toString() {
            return "Oaid{id='" + this.id + "', maySupport=" + this.maySupport + '}';
        }
    }

    @AnyThread
    void onOaidLoaded(@NonNull Oaid r10);
}
