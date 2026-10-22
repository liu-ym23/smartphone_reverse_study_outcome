package com.lynx.textra;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class JavaFontManager {
    private final AtomicInteger mCount;
    private final LinkedList<JavaTypeface> mFontList;
    private final LinkedHashMap<JavaTypeface.FontKey, JavaTypeface> mFontMap;
    private final long mNativeHandler;

    private native void BindNativeInstance(long r1, JavaFontManager r3);

    private native long CreateNativeTypeface(long r1);

    public long GetNativeHandler() {
        return this.mNativeHandler;
    }

    public JavaFontManager(long r3) {
        this.mCount = new AtomicInteger(0);
        this.mFontMap = new LinkedHashMap();
        this.mFontList = new LinkedList();
        this.mNativeHandler = r3;
    }

    public synchronized JavaTypeface GetTypefaceByIndex(int r4) {
        monitor-enter(this);
        Iterator<JavaTypeface> r0 = this.mFontMap.values().iterator();     // Catch: Throwable -> L20
    L5:
        if (r0.hasNext() == false) goto L10;
        JavaTypeface r1 = r0.next();     // Catch: Throwable -> L20
        if (r1.mIndex != r4) goto L5;
        monitor-exit(this);
        return r1;
    L10:
        Iterator<JavaTypeface> r2 = this.mFontList.iterator();     // Catch: Throwable -> L20
    L11:
        if (r2.hasNext() == false) goto L17;
        JavaTypeface r3 = r2.next();     // Catch: Throwable -> L20
        if (r3.mIndex != r4) goto L11;
        monitor-exit(this);
        return r3;
    L17:
        monitor-exit(this);
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public long onMatchTypefaceIndex(long r1) {
        return GetTypefaceByIndex((int) r1).mNativeHandler;
    }

    public synchronized JavaTypeface RegisterShapeFont(Font r8, JavaTypeface.FontKey r9) {
        monitor-enter(this);
        JavaTypeface r0 = this.mFontMap.get(r9);     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = new JavaTypeface(this.mCount.incrementAndGet(), r8, r9, CreateNativeTypeface(this.mNativeHandler));     // Catch: Throwable -> L8
        this.mFontMap.put(r9, r0);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized JavaTypeface RegisterTypeface(Typeface r8, JavaTypeface.FontKey r9, long r10) {
        monitor-enter(this);
        JavaTypeface r0 = new JavaTypeface(this.mCount.incrementAndGet(), r8, r9, r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized JavaTypeface CreateOrRegisterTypeface(Typeface r3, String r4, int r5, boolean r6) {
        monitor-enter(this);
        JavaTypeface.FontKey r0 = new JavaTypeface.FontKey();     // Catch: Throwable -> L17
        if (r4 != null) goto L6;
    L8:
        r0.mFontWeight = r5;     // Catch: Throwable -> L17
        r0.mItalic = r6;     // Catch: Throwable -> L17
        JavaTypeface r7 = this.mFontMap.get(r0);     // Catch: Throwable -> L17
        if (r7 != null) goto L12;
        r7 = RegisterTypeface(r3, r0, CreateNativeTypeface(this.mNativeHandler));     // Catch: Throwable -> L17
    L14:
        this.mFontMap.put(r0, r7);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r7;
    L12:
        if (r7.mTypeface == r3) goto L14;
        this.mFontList.add(r7);     // Catch: Throwable -> L17
        r7 = RegisterTypeface(r3, r0, CreateNativeTypeface(this.mNativeHandler));     // Catch: Throwable -> L17
        goto L14
    L6:
        if (r4.isEmpty() == true) goto L8;
        r0.mFontFamily = r4;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized long onMatchFamilyStyle(String r4, int r5, boolean r6, long r7) {
        monitor-enter(this);
        JavaTypeface.FontKey r0 = new JavaTypeface.FontKey();     // Catch: Throwable -> L49
        if (r4 != null) goto L6;
    L8:
        r0.mFontWeight = r5;     // Catch: Throwable -> L49
        r0.mItalic = r6;     // Catch: Throwable -> L49
        JavaTypeface r8 = this.mFontMap.get(r0);     // Catch: Throwable -> L49
        if (r8 == null) goto L13;
        long r9 = r8.mNativeHandler;     // Catch: Throwable -> L49
        monitor-exit(this);
        return r9;
    L13:
        r0.mFontFamily = NameKeys.UnloadStrategy_No_Strategy;     // Catch: Throwable -> L49
        JavaTypeface r10 = this.mFontMap.get(r0);     // Catch: Throwable -> L49
        if (r10 == null) goto L19;
        long r11 = r10.mNativeHandler;     // Catch: Throwable -> L49
        monitor-exit(this);
        return r11;
    L19:
        if (r5 < 700) goto L22;
        if (r6 == false) goto L22;
        int r12 = 3;
    L27:
        long r13 = 0;
        JavaTypeface r1 = null;
        Typeface r14 = Typeface.create(Typeface.DEFAULT, r12);     // Catch: Exception -> L36 Throwable -> L49
        if (r14 != null) goto L31;
        r14 = Typeface.DEFAULT;     // Catch: Exception -> L36 Throwable -> L49
    L31:
        JavaTypeface r15 = RegisterTypeface(r14, r0, r7);     // Catch: Exception -> L36 Throwable -> L49
        if (r15.mNativeHandler == 0) goto L37;
        r1 = r15;
    L37:
        if (r1 == null) goto L40;
        this.mFontMap.put(r0, r1);     // Catch: Throwable -> L49
    L45:
        if (r1 == null) goto L47;
        r13 = r1.mNativeHandler;     // Catch: Throwable -> L49
    L47:
        monitor-exit(this);
        return r13;
    L40:
        if (this.mFontMap.isEmpty() == true) goto L43;
        r1 = this.mFontMap.values().iterator().next();     // Catch: Throwable -> L49
        goto L45
    L43:
        if (this.mFontList.isEmpty() == true) goto L45;
        r1 = this.mFontList.getFirst();     // Catch: Throwable -> L49
    L22:
        if (r5 < 700) goto L24;
        r12 = 1;
        goto L27
    L24:
        if (r6 == false) goto L26;
        r12 = 2;
        goto L27
    L26:
        r12 = 0;
        goto L27
    L6:
        if (r4.isEmpty() == true) goto L8;
        r0.mFontFamily = r4;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    }
}
