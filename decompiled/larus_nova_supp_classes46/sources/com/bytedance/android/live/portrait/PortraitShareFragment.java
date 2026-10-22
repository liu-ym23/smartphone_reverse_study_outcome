package com.bytedance.android.live.portrait;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.LiveShareBaseFragment;
import com.bytedance.android.live.api.MatchShareApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.view.f;
import com.bytedance.android.livesdk.config.yx0;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.vs.model.SearchPanelParam;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import io.reactivex.Observable;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ls0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/portrait/PortraitShareFragment;", "Lcom/bytedance/android/live/LiveShareBaseFragment;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitShareFragment extends LiveShareBaseFragment {
    public static final /* synthetic */ int i = 0;
    public MatchShareParam d;
    public View e;
    public View f;
    public LiveVerticalViewPager g;
    public PortraitShareAdapter h;

    public static final class a {
        public static PortraitShareFragment a(MatchShareParam r4) {
            if (((Boolean) yx0.a.getValue()).booleanValue() == false) goto L6;
            PortraitShareFragment r0 = new PortraitShareFragment();
            r0.d = r4;
            return r0;
        L6:
            Bundle r1 = new Bundle();
            if (r4 != null) goto L14;
        L12:
            PortraitShareFragment r5 = new PortraitShareFragment();
            r5.setArguments(r1);
            return r5;
        L14:
            r1.putString("MATCH_PARAMS", GsonHelper.get().toJson(r4, MatchShareParam.class));     // Catch: Exception -> L10
        L10:
            e = move-exception;
            ALogger.e("match_live_share", e);
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/portrait/PortraitShareFragment$b", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/livesdk/vs/model/MatchShareParam;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<MatchShareParam> {
        public b() {
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PortraitShareFragment a;

        public c(PortraitShareFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            FragmentActivity r2 = this.a.getActivity();
            if (r2 == null) goto L6;
            r2.finish();
            return;
        }
    }

    static {
    }

    public PortraitShareFragment() {
        this.d = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        PortraitShareAdapter r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collectVideoAdapter");
    L5:
        Iterator r1 = ((LinkedHashMap) r0.a).entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        f r2 = (f) ((Map.Entry) r1.next()).getValue();
        SimpleMediaView r3 = r2.b;
        if (r3 == null) goto L11;
        r3.setAsyncRelease(true);
    L11:
        SimpleMediaView r4 = r2.b;
        if (r4 == null) goto L7;
        r4.m();
        goto L7
    }

    public final void onResume() {
        super.onResume();
        PortraitShareAdapter r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collectVideoAdapter");
    L5:
        Map<Integer, f> r1 = r0.a;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        f r3 = (f) r2.get(Integer.valueOf(r0.d));
        if (r3 == null) goto L9;
        r3.a(true);
        return;
    }

    public final void onStop() {
        super.onStop();
        PortraitShareAdapter r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collectVideoAdapter");
    L5:
        Map<Integer, f> r1 = r0.a;
        LinkedHashMap r2 = (LinkedHashMap) r1;
        f r3 = (f) r2.get(Integer.valueOf(r0.d));
        if (r3 == null) goto L9;
        r3.b();
        return;
    }

    public final void onCreate(Bundle r4) {
        super/*androidx.fragment.app.Fragment*/.onCreate(r4);
        if (((Boolean) yx0.a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        if (getArguments() != null) goto L18;
        return;
    L18:
        Type r5 = new b().getType();     // Catch: Exception -> L15
        Gson r0 = GsonHelper.get();     // Catch: Exception -> L15
        Bundle r1 = getArguments();     // Catch: Exception -> L15
        if (r1 == null) goto L10;
        String r2 = r1.getString("MATCH_PARAMS");     // Catch: Exception -> L15
    L11:
        MatchShareParam r6 = (MatchShareParam) r0.fromJson(r2, r5);     // Catch: Exception -> L15
        if (r6 == null) goto L21;
        this.d = r6;     // Catch: Exception -> L15
        return;
    L21:
        return;
    L10:
        r2 = null;
    L15:
        e = move-exception;
        ALogger.e("match_live_share", e);
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        View r8 = this.e;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        this.g = r8.findViewById(2131389930);
        View r9 = this.e;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L8:
        View r10 = r9.findViewById(2131389913);
        this.f = r10;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
    L11:
        r10.setOnClickListener(new c(this));
        Context r11 = getContext();
        if (r11 == null) goto L19;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L19;
        LiveVerticalViewPager r2 = this.g;
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("previewList");
    L18:
        this.h = new PortraitShareAdapter(r0, r11, r2);
    L19:
        LiveVerticalViewPager r12 = this.g;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("previewList");
    L22:
        r12.setOffscreenPageLimit(1);
        LiveVerticalViewPager r13 = this.g;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("previewList");
    L25:
        PortraitShareAdapter r1 = this.h;
        if (r1 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("collectVideoAdapter");
    L28:
        r13.setAdapter(r1);
        PortraitShareAdapter r14 = this.h;
        if (r14 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("collectVideoAdapter");
    L31:
        MatchShareParam r3 = this.d;
        if (r3 == null) goto L34;
        r14.c = r3;
        r14.notifyDataSetChanged();
    L35:
        LiveVerticalViewPager r15 = this.g;
        if (r15 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("previewList");
    L38:
        PortraitShareAdapter r16 = this.h;
        if (r16 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("collectVideoAdapter");
    L41:
        MatchShareParam r4 = this.d;
        List r5 = null;
        if (r4 == null) goto L44;
        String r17 = r4.b;
    L45:
        List r18 = r16.c.d;
        int r19 = 0;
        if (r18 == null) goto L54;
        Iterator r20 = r18.iterator();
        int r21 = 0;
    L49:
        if (r20.hasNext() == false) goto L54;
        if (Intrinsics.areEqual(((CollectionItem) r20.next()).getCollectionId(), r17) == true) goto L52;
        r21 = r21 + 1;
        goto L49
    L52:
        r19 = r21;
    L54:
        r15.setCurrentItem(r19);
        MatchShareParam r22 = this.d;
        if (r22 == null) goto L60;
        SearchPanelParam r23 = r22.j;
        if (r23 == null) goto L60;
        r5 = r23.b;
    L60:
        if (CollectionUtils.isEmpty(r5) == true) goto L82;
        MatchShareApi r24 = (MatchShareApi) com.bytedance.android.live.network.c.b().e(MatchShareApi.class);
        MatchShareParam r25 = this.d;
        String r26 = "";
        if (r25 == null) goto L67;
        IRoom r27 = r25.f;
        if (r27 == null) goto L67;
        String r28 = String.valueOf(r27.getRoomId());
        if (r28 == null) goto L67;
    L68:
        MatchShareParam r29 = this.d;
        if (r29 == null) goto L76;
        Episode r30 = r29.g;
        if (r30 == null) goto L76;
        String r31 = r30.idStr;
        if (r31 == null) goto L76;
        r26 = r31;
    L76:
        Observable r32 = r24.getCollectionList(r28, r26);
        if (r32 == null) goto L83;
        r32.subscribe(new ls0.c(this), d.a);
        return;
    L83:
        return;
    L67:
        r28 = "";
        goto L68
    L82:
        return;
    L44:
        r17 = null;
        goto L45
    L34:
        r14.getClass();
        goto L35
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131567983, r3, false);
        this.e = r5;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        return r5;
    }
}
