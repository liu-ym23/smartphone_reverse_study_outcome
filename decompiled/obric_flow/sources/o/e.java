package o;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f20373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f20374b;

    public e(String... r5) {
        this.f20373a = Arrays.asList(r5);
    }

    public final boolean a(int r10, String r11) {
        List r12 = this.f20373a;
        if (r10 < r12.size()) goto L6;
        return false;
    L6:
        if (r10 != (r12.size() - 1)) goto L8;
        boolean r5 = true;
    L9:
        String r13 = (String) r12.get(r10);
        if (r13.equals("**") == false) goto L12;
        if (r5 == false) goto L28;
    L37:
        if (r5 == false) goto L39;
        return true;
    L39:
        int r14 = r10 + 1;
        if (r14 >= (r12.size() - 1)) goto L43;
        return false;
    L43:
        return ((String) r12.get(r14)).equals(r11);
    L28:
        if (((String) r12.get(r10 + 1)).equals(r11) == false) goto L37;
        if (r10 == (r12.size() - 2)) goto L36;
        if (r10 == (r12.size() - 3)) goto L34;
        return false;
    L34:
        if (((String) j0.e(r12, 1)).equals("**") == true) goto L36;
        return false;
    L36:
        return true;
    L12:
        if (r13.equals(r11) == false) goto L14;
    L17:
        boolean r15 = true;
    L18:
        if (r5 == false) goto L20;
    L23:
        if (r15 == true) goto L25;
        return false;
    L25:
        return true;
    L20:
        if (r10 == (r12.size() - 2)) goto L22;
        return false;
    L22:
        if (((String) j0.e(r12, 1)).equals("**") == true) goto L23;
        return false;
    L14:
        if (r13.equals(XPath.WILDCARD) == true) goto L17;
        r15 = false;
        goto L18
    L8:
        r5 = false;
        goto L9
    }

    public final int b(int r5, String r10) {
        if ("__container".equals(r10) == false) goto L5;
        return 0;
    L5:
        List r11 = this.f20373a;
        if (((String) r11.get(r5)).equals("**") == true) goto L9;
        return 1;
    L9:
        if (r5 != (r11.size() - 1)) goto L12;
        return 0;
    L12:
        if (((String) r11.get(r5 + 1)).equals(r10) == false) goto L15;
        return 2;
    L15:
        return 0;
    }

    public final boolean c(int r5, String r10) {
        if ("__container".equals(r10) == false) goto L5;
        return true;
    L5:
        List r11 = this.f20373a;
        if (r5 < r11.size()) goto L9;
        return false;
    L9:
        if (((String) r11.get(r5)).equals(r10) == false) goto L11;
    L16:
        return true;
    L11:
        if (((String) r11.get(r5)).equals("**") == true) goto L16;
        if (((String) r11.get(r5)).equals(XPath.WILDCARD) == true) goto L16;
        return false;
    }

    public final boolean d(int r5, String r10) {
        if ("__container".equals(r10) == false) goto L5;
        return true;
    L5:
        List r11 = this.f20373a;
        if (r5 >= (r11.size() - 1)) goto L8;
        return true;
    L8:
        if (((String) r11.get(r5)).equals("**") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("KeyPath{keys=");
        r5.append(this.f20373a);
        r5.append(",resolved=");
        if (this.f20374b == null) goto L5;
        boolean r10 = true;
    L7:
        return androidx.constraintlayout.motion.widget.a.w(r5, r10, '}');
    L5:
        r10 = false;
        goto L7
    }

    public e(e r5) {
        this.f20373a = new ArrayList(r5.f20373a);
        this.f20374b = r5.f20374b;
    }
}
