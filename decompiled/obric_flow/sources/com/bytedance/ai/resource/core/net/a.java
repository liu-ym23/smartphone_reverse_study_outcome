package com.bytedance.ai.resource.core.net;

import android.text.Editable;
import com.bytedance.ai.settings.AISDKSettingsCore;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.ivy.ivykit.base.resource.IvyResourceServiceImpl;
import com.lynx.tasm.h;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import org.json.JSONObject;
import pg.b;
import r9.c;
import xs.d;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements bi.a, b, ShapeAppearanceModel.CornerSizeUnaryOperator, TextInputLayout.LengthCounter, ObjectConstructor, h, d, ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2675a;

    public /* synthetic */ a(int r5) {
        this.f2675a = r5;
    }

    @Override // com.lynx.tasm.h
    public void a(String r5) {
        System.loadLibrary(r5);
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public CornerSize apply(CornerSize r5) {
        return MaskableFrameLayout.a(r5);
    }

    @Override // ya.a
    public void b(String r5, JSONObject r10) {
        IvyResourceServiceImpl.a(r5, r10);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch(this.f2675a) {
            case 5: goto L21;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L13;
            case 10: goto L11;
            case 11: goto L9;
            case 12: goto L7;
            default: goto L5;
        };
    L5:
        return new TreeMap();
    L7:
        return new LinkedHashMap();
    L9:
        return ConstructorConstructor.c();
    L11:
        return new ArrayDeque();
    L13:
        return new TreeSet();
    L15:
        return new LinkedHashSet();
    L17:
        return new ConcurrentSkipListMap();
    L19:
        return new ConcurrentHashMap();
    L21:
        return new ArrayList();
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int countLength(Editable r5) {
        return TextInputLayout.b(r5);
    }

    @Override // pg.b
    public pg.d create() {
        return AISDKSettingsCore.b();
    }

    @Override // bi.a
    public bi.b get() {
        switch(this.f2675a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new c(17);
    L7:
        return AISDKApiManager.d();
    L9:
        return AISDKApiManager.b();
    }
}
