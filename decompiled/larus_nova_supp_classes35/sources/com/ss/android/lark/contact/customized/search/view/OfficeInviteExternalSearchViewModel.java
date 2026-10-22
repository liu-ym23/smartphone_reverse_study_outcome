package com.ss.android.lark.contact.customized.search.view;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v2.SearchContactsDoubaoRequest;
import com.bytedance.lark.pb.contact.v2.SearchContactsDoubaoResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.contact.base.utils.InvApmUtils;
import com.ss.android.lark.sdk.SdkSender;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/contact/customized/search/model/OfficeInviteExternalSearchUiState;", "uiState", "Landroidx/lifecycle/LiveData;", "getUiState", "()Landroidx/lifecycle/LiveData;", "latestSearchId", BuildConfig.FLAVOR, "currentQuery", BuildConfig.FLAVOR, "init", BuildConfig.FLAVOR, "onQueryChanged", "query", "onSearch", "updateQuery", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalSearchViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String SCENE = "page_search_contact";
    private static final String TAG = "Contact_SearchViewModel";
    private final MutableLiveData<o9b.a> _uiState;
    private String currentQuery;
    private int latestSearchId;
    private final LiveData<o9b.a> uiState;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final void init() {
        if (this.currentQuery.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        this._uiState.setValue(o9b.a.d.a);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onSearch() {
        final String r6 = this.currentQuery;
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        this._uiState.setValue(o9b.a.d.a);
        return;
    L9:
        final long r4 = SystemClock.elapsedRealtime();
        final int r2 = this.latestSearchId + 1;
        this.latestSearchId = r2;
        this._uiState.setValue(o9b.a.b.a);
        int r1 = p9b.b.a;
        IGetDataCallback<SearchContactsDoubaoResponse> r8 = new AnonymousClass1(r6, r2, this, r4);
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Command r3 = Command.SEARCH_CONTACTS_DOUBAO;
        SearchContactsDoubaoRequest.Builder r5 = new SearchContactsDoubaoRequest.Builder().contact_content(r6);
        InvApmUtils.GetDataCallback r7 = new InvApmUtils.GetDataCallback(r8, "ug_invite_external_orientation_search", null, 4, null);
        final ProtoAdapter r9 = SearchContactsDoubaoResponse.ADAPTER;
        SdkSender.asynSendRequestNonWrap(r3, r5, r7, new p9b.a(r9));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public OfficeInviteExternalSearchViewModel() {
        MutableLiveData<o9b.a> r0 = new MutableLiveData();
        this._uiState = r0;
        this.uiState = r0;
        this.currentQuery = BuildConfig.FLAVOR;
    }

    public final LiveData<o9b.a> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ int access$getLatestSearchId$p(OfficeInviteExternalSearchViewModel r0) {
        return r0.latestSearchId;
    }

    public static final /* synthetic */ MutableLiveData access$get_uiState$p(OfficeInviteExternalSearchViewModel r0) {
        return r0._uiState;
    }

    public final void onQueryChanged(String r8) {
        Intrinsics.checkNotNullParameter(r8, "query");
        this.currentQuery = StringsKt.replace$default(r8, " ", BuildConfig.FLAVOR, false, 4, null);
        this._uiState.setValue(o9b.a.d.a);
    }

    public final void updateQuery(String r8) {
        Intrinsics.checkNotNullParameter(r8, "query");
        this.currentQuery = StringsKt.replace$default(r8, " ", BuildConfig.FLAVOR, false, 4, null);
    }
}
