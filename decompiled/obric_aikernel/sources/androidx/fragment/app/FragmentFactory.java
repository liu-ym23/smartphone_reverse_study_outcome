package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class FragmentFactory {
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = null;

    static {
        sClassCacheMap = new SimpleArrayMap();
    }

    public FragmentFactory() {
    }

    static boolean isFragmentClass(@NonNull ClassLoader r10, @NonNull String r11) {
        return Fragment.class.isAssignableFrom(loadClass(r10, r11));
    L4:
        return false;
    }

    @NonNull
    private static Class<?> loadClass(@NonNull ClassLoader r10, @NonNull String r11) {
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> r12 = sClassCacheMap;
        SimpleArrayMap<String, Class<?>> r13 = r12.get(r10);
        if (r13 != null) goto L5;
        r13 = new SimpleArrayMap();
        r12.put(r10, r13);
    L5:
        Class<?> r14 = r13.get(r11);
        if (r14 != null) goto L9;
        Class<?> r15 = Class.forName(r11, false, r10);
        r13.put(r11, r15);
        return r15;
    L9:
        return r14;
    }

    @NonNull
    public static Class<? extends Fragment> loadFragmentClass(@NonNull ClassLoader r10, @NonNull String r11) {
        return loadClass(r10, r11);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class is a valid subclass of Fragment", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class name exists", e);
    }

    @NonNull
    public Fragment instantiate(@NonNull ClassLoader r10, @NonNull String r11) {
        return loadFragmentClass(r10, r11).getConstructor(new Class[0]).newInstance(new Object[0]);
    L11:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L14:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r11 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r11 + ": could not find Fragment constructor", e);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r11 + ": calling Fragment constructor caused an exception", e);
    }
}
