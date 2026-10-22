package com.ss.android.lark.location.dependency.impl;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(bqb.a.class)
public class LocationDependencyImpl implements bqb.a {
    private static final String TAG = "LocationDependencyImpl";
    private static final Map<Object, y> mListenerMap = null;

    public class a implements bqb.a.InterfaceC0012a {
        public a() {
        }
    }

    public LocationDependencyImpl() {
    }

    static {
        mListenerMap = new ConcurrentHashMap();
    }

    public bqb.a.InterfaceC0012a getAppStateDependency() {
        return new a();
    }

    @Override // bqb.a
    public Context getContext() {
        return LarkContext.getApplication();
    }

    public static /* synthetic */ Map access$000() {
        return mListenerMap;
    }
}
