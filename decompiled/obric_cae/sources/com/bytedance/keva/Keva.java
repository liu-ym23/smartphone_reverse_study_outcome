package com.bytedance.keva;

import android.content.Context;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class Keva {

    public interface OnChangeListener {
        void onChanged(Keva r8, String r10);
    }

    public Keva() {
    }

    public static void forceInit() {
        KevaImpl.forceInitImpl();
    }

    public static Keva getRepo(String r8) {
        return KevaImpl.getRepo(r8, 0);
    }

    public static Keva getRepoFromSp(Context r8, String r10, int r11) {
        return KevaImpl.getRepoFromSp(r8, r10, r11);
    }

    public static Keva getRepoFromSpSync(Context r8, String r10, int r11) {
        return KevaImpl.getRepoFromSpSync(r8, r10, r11);
    }

    public static Keva getRepoSync(String r8, int r10) {
        return KevaImpl.getRepoSync(r8, r10);
    }

    public static Keva getRepoSyncWithPath(String r8, String r10, int r11) {
        return KevaImpl.getRepoSyncWithPath(r8, r10, r11);
    }

    public static boolean isRepoPorted(String r8) {
        return KevaImpl.isRepoPorted(r8);
    }

    public abstract Map<String, Object> buildNewMap(Map<String, Object> r8);

    public abstract void clear();

    public abstract boolean contains(String r8);

    public abstract int count();

    public abstract void dump();

    public abstract void erase(String r8);

    public abstract Map<String, ?> getAll();

    public abstract boolean getBoolean(String r8, boolean r10);

    public abstract byte[] getBytes(String r8, byte[] r10);

    public abstract byte[] getBytesJustDisk(String r8, byte[] r10);

    public abstract double getDouble(String r8, double r10);

    public abstract float getFloat(String r8, float r10);

    public abstract int getInt(String r8, int r10);

    public abstract long getLong(String r8, long r10);

    public abstract String getString(String r8, String r10);

    public abstract String[] getStringArray(String r8, String[] r10);

    public abstract String[] getStringArrayJustDisk(String r8, String[] r10);

    public abstract String getStringJustDisk(String r8, String r10);

    public abstract Set<String> getStringSet(String r8, Set<String> r10);

    public abstract Set<String> getStringSetJustDisk(String r8, Set<String> r10);

    public abstract String name();

    public abstract void registerChangeListener(OnChangeListener r8);

    public abstract void storeBoolean(String r8, boolean r10);

    public abstract void storeBytes(String r8, byte[] r10);

    public abstract void storeBytesJustDisk(String r8, byte[] r10);

    public abstract void storeDouble(String r8, double r10);

    public abstract void storeFloat(String r8, float r10);

    public abstract void storeInt(String r8, int r10);

    public abstract void storeLong(String r8, long r10);

    public abstract void storeString(String r8, String r10);

    public abstract void storeStringArray(String r8, String[] r10);

    public abstract void storeStringArrayJustDisk(String r8, String[] r10);

    public abstract void storeStringJustDisk(String r8, String r10);

    public abstract void storeStringSet(String r8, Set<String> r10);

    public abstract void storeStringSetJustDisk(String r8, Set<String> r10);

    public abstract void unRegisterChangeListener(OnChangeListener r8);

    public static Keva getRepo(String r8, int r10) {
        return KevaImpl.getRepo(r8, r10);
    }
}
