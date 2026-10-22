package com.obric.assistant.interaction.api.service;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "", "onActivityReady", "", "activity", "Landroid/app/Activity;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onFragmentCreate", "fragment", "Landroidx/fragment/app/Fragment;", "onFragmentStart", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ActivityProxyListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onFragmentCreate(ActivityProxyListener r0, Fragment r1) {
            Intrinsics.checkNotNullParameter(r1, "fragment");
        }

        public static void onFragmentStart(ActivityProxyListener r0, Fragment r1) {
            Intrinsics.checkNotNullParameter(r1, "fragment");
        }
    }

    void onActivityReady(Activity r1);

    void onActivityResult(int r1, int r2, Intent r3);

    void onFragmentCreate(Fragment r1);

    void onFragmentStart(Fragment r1);
}
