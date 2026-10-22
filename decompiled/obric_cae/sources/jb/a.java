package jb;

import android.annotation.SuppressLint;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Method> f8816a = null;

    /* JADX INFO: renamed from: jb.a$a, reason: collision with other inner class name */
    public static final enum EnumC0105a extends Enum<EnumC0105a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumC0105a[] f8817a = null;

        static {
            f8817a = new EnumC0105a[]{new EnumC0105a(BdimCategoryConstants.VALUE_NONE, 0), new EnumC0105a("NORMAL_BLUR", 1), new EnumC0105a("PROGRESS_BLUR_DOWN_UP", 2), new EnumC0105a("PROGRESS_BLUR_UP_DOWN", 3), new EnumC0105a("PROGRESS_BLUR_LEFT_RIGHT", 4), new EnumC0105a("PROGRESS_BLUR_RIGHT_LEFT", 5)};
        }

        public EnumC0105a(String r8, int r10) {
            super(r8, r10);
        }

        public static EnumC0105a valueOf(String r8) {
            return (EnumC0105a) Enum.valueOf(EnumC0105a.class, r8);
        }

        public static EnumC0105a[] values() {
            return (EnumC0105a[]) f8817a.clone();
        }
    }

    static {
        f8816a = new HashMap();
    }
}
