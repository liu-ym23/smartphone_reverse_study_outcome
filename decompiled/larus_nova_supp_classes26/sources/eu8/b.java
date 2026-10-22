package eu8;

import android.content.Context;
import com.google.gson.JsonElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends a {
    public final ArrayList<File> c;

    @Override // eu8.a
    public final String a() {
        StringBuilder r0 = new StringBuilder();
        ArrayList<File> r1 = this.c;
        if (r1 == null) goto L12;
        Iterator<File> r2 = r1.iterator();
        boolean r3 = false;
    L6:
        if (r2.hasNext() == false) goto L14;
        File r4 = r2.next();
        if (r4.exists() == false) goto L6;
        if (r4.isFile() == false) goto L6;
        r3 = r4.delete();
        r0.append(r4);
    L14:
        return String.format("delete %s result %b", new Object[]{r0, Boolean.valueOf(r3)});
    L12:
        r3 = false;
        goto L14
    }

    public b(Context r1, JsonElement r2, ArrayList<File> r3) {
        super(r1, r2);
        this.c = r3;
    }
}
