package com.bytedance.crash.dumper;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ViewTree {
    public static final String FILE_NAME = "viewTree.txt";

    public ViewTree() {
    }

    public static void dump(File r10) {
        JSONArray r11 = getViewTree();
        if (r11 != null) goto L8;
        return;
    L8:
        FileUtils.writeFile(new File(r10, FILE_NAME), r11, false);     // Catch: Throwable -> L7
        return;
    }

    @Nullable
    private static JSONArray getViewTree() {
        JSONArray r10 = new JSONArray();
        ArrayList<WeakReference<Activity>> r11 = ActivityLifecycle.getAllActivities();
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.size() <= 0) goto L49;
        LinkedList r12 = new LinkedList();
        Iterator<WeakReference<Activity>> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L18;
        Activity r14 = r13.next().get();
        if (r14 == null) goto L9;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L9;
        View r16 = r15.peekDecorView();
        if (r16 == null) goto L9;
        JSONObject r17 = new JSONObject();
        r12.add(new Pair(r16, r17));
        r10.put(r17);
    L18:
        if (r12.isEmpty() == true) goto L27;
        Pair r18 = (Pair) r12.pop();
        View r19 = (View) r18.first;
        JSONObject r20 = (JSONObject) r18.second;
        JSONUtils.put(r20, "cls", String.valueOf(r19.getClass()));
        if ((r19 instanceof ViewGroup) == false) goto L18;
        ViewGroup r21 = (ViewGroup) r19;
        int r22 = r21.getChildCount();
        JSONArray r23 = new JSONArray();
        JSONUtils.put(r20, "children", r23);
        int r24 = 0;
    L22:
        if (r24 >= r22) goto L18;
        View r25 = r21.getChildAt(r24);     // Catch: Throwable -> L30
        if (r25 == null) goto L26;
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L30
        r23.put(r26);     // Catch: Throwable -> L30
        r12.push(new Pair(r25, r26));     // Catch: Throwable -> L30
    L26:
        r24 = r24 + 1;
        goto L22
    L27:
        return r10;
    L49:
        return null;
    }
}
