package com.bytedance.crash.dumper;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ViewTree {
    public static final String FILE_NAME = "viewTree.txt";

    public ViewTree() {
    }

    public static void dump(File r3) {
        JSONArray r0 = getViewTree();
        if (r0 != null) goto L8;
        return;
    L8:
        FileUtils.writeFile(new File(r3, FILE_NAME), r0, false);     // Catch: Throwable -> L7
        return;
    }

    private static JSONArray getViewTree() {
        JSONArray r0 = new JSONArray();
        ArrayList<WeakReference<Activity>> r1 = ActivityLifecycle.getAllActivities();
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.size() <= 0) goto L49;
        LinkedList r2 = new LinkedList();
        Iterator<WeakReference<Activity>> r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        Activity r4 = (Activity) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), Activity.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        Window r5 = ZeusTransformUtils.getWindow(r4, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        View r6 = r5.peekDecorView();
        if (r6 == null) goto L9;
        JSONObject r7 = new JSONObject();
        r2.add(new Pair(r6, r7));
        r0.put(r7);
    L18:
        if (r2.isEmpty() == true) goto L27;
        Pair r8 = (Pair) ZeusTransformUtils.preCheckCast(r2.pop(), Pair.class, "com.obric.memorydata.plugin");
        View r9 = (View) ZeusTransformUtils.preCheckCast(r8.first, View.class, "com.obric.memorydata.plugin");
        JSONObject r10 = (JSONObject) ZeusTransformUtils.preCheckCast(r8.second, JSONObject.class, "com.obric.memorydata.plugin");
        JSONUtils.put(r10, "cls", String.valueOf(r9.getClass()));
        if (ZeusTransformUtils.instanceOf(r9, ViewGroup.class) == false) goto L18;
        ViewGroup r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin");
        int r12 = r11.getChildCount();
        JSONArray r13 = new JSONArray();
        JSONUtils.put(r10, "children", r13);
        int r14 = 0;
    L22:
        if (r14 >= r12) goto L18;
        View r15 = r11.getChildAt(r14);     // Catch: Throwable -> L30
        if (r15 == null) goto L26;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L30
        r13.put(r16);     // Catch: Throwable -> L30
        r2.push(new Pair(r15, r16));     // Catch: Throwable -> L30
    L26:
        r14 = r14 + 1;
        goto L22
    L27:
        return r0;
    L49:
        return null;
    }
}
