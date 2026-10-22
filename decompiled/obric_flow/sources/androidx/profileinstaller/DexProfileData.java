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

    public DexProfileData(@NonNull String r5, @NonNull String r10, long r11, long r12, int r13, int r14, int r15, @NonNull int[] r16, @NonNull TreeMap<Integer, Integer> r17) {
        this.apkName = r5;
        this.dexName = r10;
        this.dexChecksum = r11;
        this.mTypeIdCount = r12;
        this.classSetSize = r13;
        this.hotMethodRegionSize = r14;
        this.numMethodIds = r15;
        this.classes = r16;
        this.methods = r17;
    }
}
