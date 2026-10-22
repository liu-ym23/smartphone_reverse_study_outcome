package com.ss.android.lark.officesdk.integrator.mock;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import vqb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(a.class)
public class MainTabApiMock implements a {
    private static final String TAG = "OfficeSdkMock";

    public MainTabApiMock() {
    }

    public void addFavoriteTab(com.ss.android.lark.maintab.export.a r1, IGetDataCallback<Unit> r2, boolean r3) {
    }

    public void addFavoriteTab(String r1, String r2, Map<String, String> r3, IGetDataCallback<Unit> r4) {
    }

    public void addFavoriteTabBySlide(Activity r1, Function0<com.ss.android.lark.maintab.export.a> r2) {
    }

    public void addVisitRecord(com.ss.android.lark.maintab.export.a r1) {
    }

    public void addVisitRecordV2(com.ss.android.lark.maintab.export.a r1) {
    }

    public boolean enableFgMainTabContainer() {
        return false;
    }

    public boolean enableSearchForseti() {
        return false;
    }

    public String getConversationTabKey() {
        return "";
    }

    public Boolean getMainTabFragmentVisibility() {
        return null;
    }

    public void makeLaunchBarSharedElementAbility(FragmentActivity r1, View r2) {
    }

    public void moveTabToPosition(int r1, Function1<? super TabAppInfo, Boolean> r2) {
    }

    public void observerMainTabFragmentVisibility(LifecycleOwner r1, Observer<Boolean> r2) {
    }

    public void prefetchFullMainTabData(String r1, String r2) {
    }

    public void setRegisterRole(String r1) {
    }

    public void startNavLauncherActivity(Context r1, View r2) {
    }

    public void getAllTabs(IGetDataCallback<List<TabAppInfo>> r2) {
        if (r2 == null) goto L5;
        r2.onSuccess(Collections.emptyList());
        return;
    }

    public void deleteFavoriteTab(String r1, TabAppInfo.BizType r2, IGetDataCallback<Unit> r3) {
        if (r3 == null) goto L5;
        r3.onSuccess(Unit.INSTANCE);
        return;
    }

    public void deleteFavoriteTabForMultiSync(String r1, TabAppInfo.BizType r2, IGetDataCallback<Unit> r3) {
        if (r3 == null) goto L5;
        r3.onSuccess(Unit.INSTANCE);
        return;
    }

    public void isExistFavoriteTab(String r1, TabAppInfo.BizType r2, IGetDataCallback<Boolean> r3) {
        if (r3 == null) goto L5;
        r3.onSuccess(Boolean.FALSE);
        return;
    }

    public void isExistFavoriteTabForMultiSync(String r1, TabAppInfo.BizType r2, IGetDataCallback<Boolean> r3) {
        if (r3 == null) goto L5;
        r3.onSuccess(Boolean.FALSE);
        return;
    }

    public void deleteFavoriteTab(String r1, String r2, TabAppInfo.BizType r3, IGetDataCallback<Unit> r4) {
        if (r4 == null) goto L5;
        r4.onSuccess(Unit.INSTANCE);
        return;
    }

    public void isExistFavoriteTab(String r1, String r2, TabAppInfo.BizType r3, IGetDataCallback<Boolean> r4) {
        if (r4 == null) goto L5;
        r4.onSuccess(Boolean.FALSE);
        return;
    }
}
