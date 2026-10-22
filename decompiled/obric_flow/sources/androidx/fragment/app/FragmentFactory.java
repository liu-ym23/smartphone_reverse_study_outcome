package androidx.fragment.app;

import ai.j0;
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

    public static boolean isFragmentClass(@NonNull ClassLoader r5, @NonNull String r10) {
        return Fragment.class.isAssignableFrom(loadClass(r5, r10));
    L4:
        return false;
    }

    @NonNull
    private static Class<?> loadClass(@NonNull ClassLoader r5, @NonNull String r10) throws ClassNotFoundException {
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> r11 = sClassCacheMap;
        SimpleArrayMap<String, Class<?>> r12 = r11.get(r5);
        if (r12 != null) goto L5;
        r12 = new SimpleArrayMap();
        r11.put(r5, r12);
    L5:
        Class<?> r13 = r12.get(r10);
        if (r13 != null) goto L9;
        Class<?> r14 = Class.forName(r10, false, r5);
        r12.put(r10, r14);
        return r14;
    L9:
        return r13;
    }

    @NonNull
    public static Class<? extends Fragment> loadFragmentClass(@NonNull ClassLoader r5, @NonNull String r10) {
        return loadClass(r5, r10);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": make sure class is a valid subclass of Fragment"), e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": make sure class name exists"), e);
    }

    @NonNull
    public Fragment instantiate(@NonNull ClassLoader r5, @NonNull String r10) {
        return loadFragmentClass(r5, r10).getConstructor(null).newInstance(null);
    L9:
        e = move-exception;
        throw new Fragment.InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L11:
        e = move-exception;
        throw new Fragment.InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L7:
        e = move-exception;
        throw new Fragment.InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": could not find Fragment constructor"), e);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException(j0.k("Unable to instantiate fragment ", r10, ": calling Fragment constructor caused an exception"), e);
    }
}
