package androidx.profileinstaller;

import androidx.annotation.NonNull;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class DexProfileData {

    @NonNull
    final String apkName;
    int classSetSize;

    @NonNull
    int[] classes;
    final long dexChecksum;

    @NonNull
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;

    @NonNull
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    DexProfileData(@NonNull String r10, @NonNull String r11, long r12, long r13, int r14, int r15, int r16, @NonNull int[] r17, @NonNull TreeMap<Integer, Integer> r18) {
        this.apkName = r10;
        this.dexName = r11;
        this.dexChecksum = r12;
        this.mTypeIdCount = r13;
        this.classSetSize = r14;
        this.hotMethodRegionSize = r15;
        this.numMethodIds = r16;
        this.classes = r17;
        this.methods = r18;
    }
}
