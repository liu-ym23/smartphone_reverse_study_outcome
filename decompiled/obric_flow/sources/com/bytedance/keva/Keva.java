package com.bytedance.keva;

import android.content.Context;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Keva {

    public interface OnChangeListener {
        void onChanged(Keva r5, String r10);
    }

    public Keva() {
    }

    public static void forceInit() {
        KevaImpl.forceInitImpl();
    }

    public static Keva getRepo(String r5) {
        return KevaImpl.getRepo(r5, 0);
    }

    public static Keva getRepoFromSp(Context r5, String r10, int r11) {
        return KevaImpl.getRepoFromSp(r5, r10, r11);
    }

    public static Keva getRepoFromSpSync(Context r5, String r10, int r11) {
        return KevaImpl.getRepoFromSpSync(r5, r10, r11);
    }

    public static Keva getRepoSync(String r5, int r10) {
        return KevaImpl.getRepoSync(r5, r10);
    }

    public static boolean isRepoPorted(String r5) {
        return KevaImpl.isRepoPorted(r5);
    }

    @Deprecated
    public int calculateSize() {
        return count();
    }

    public abstract void clear();

    public abstract boolean contains(String r5);

    public abstract int count();

    public abstract void dump();

    public abstract void erase(String r5);

    public abstract Map<String, ?> getAll();

    public abstract boolean getBoolean(String r5, boolean r10);

    public abstract byte[] getBytes(String r5, byte[] r10);

    public abstract byte[] getBytesJustDisk(String r5, byte[] r10);

    public abstract double getDouble(String r5, double r10);

    public abstract float getFloat(String r5, float r10);

    public abstract int getInt(String r5, int r10);

    public abstract long getLong(String r5, long r10);

    public abstract String getString(String r5, String r10);

    public abstract String[] getStringArray(String r5, String[] r10);

    public abstract String[] getStringArrayJustDisk(String r5, String[] r10);

    public abstract String getStringJustDisk(String r5, String r10);

    public abstract Set<String> getStringSet(String r5, Set<String> r10);

    public abstract Set<String> getStringSetJustDisk(String r5, Set<String> r10);

    public abstract String name();

    public abstract void registerChangeListener(OnChangeListener r5);

    public abstract void storeBoolean(String r5, boolean r10);

    public abstract void storeBytes(String r5, byte[] r10);

    public abstract void storeBytesJustDisk(String r5, byte[] r10);

    public abstract void storeDouble(String r5, double r10);

    public abstract void storeFloat(String r5, float r10);

    public abstract void storeInt(String r5, int r10);

    public abstract void storeLong(String r5, long r10);

    public abstract void storeString(String r5, String r10);

    public abstract void storeStringArray(String r5, String[] r10);

    public abstract void storeStringArrayJustDisk(String r5, String[] r10);

    public abstract void storeStringJustDisk(String r5, String r10);

    public abstract void storeStringSet(String r5, Set<String> r10);

    public abstract void storeStringSetJustDisk(String r5, Set<String> r10);

    public abstract void unRegisterChangeListener(OnChangeListener r5);

    public static Keva getRepo(String r5, int r10) {
        return KevaImpl.getRepo(r5, r10);
    }
}
