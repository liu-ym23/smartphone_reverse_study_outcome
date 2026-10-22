package com.ss.android.lark.contact.customized.externalcontact.data;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.GetSubordinateDepartmentsRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.customized.department.d;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mtb.i;
import mtb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class EnterpriseContactsLoader extends BaseContactsLoader {
    public static final /* synthetic */ int g = 0;
    public final MutableLiveData<i9b.a<List<m>>> e;
    public List<? extends m> f;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void d() {
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void b() {
        Log.i("Contact_EnterpriseLoader", "fetchData");
        this.f = CollectionsKt.emptyList();
        this.e.setValue(i9b.a.b.a);
        int r0 = d.a;
        IGetDataCallback<List<? extends i>> r1 = new EnterpriseContactsLoader$fetchData$1(this);
        Intrinsics.checkNotNullParameter(r1, "callback");
        GetSubordinateDepartmentsRequest.Builder r2 = new GetSubordinateDepartmentsRequest.Builder();
        SdkSender.asynSendRequestNonWrap(Command.GET_SUBORDINATE_DEPARTMENTS, r2, r1, com.ss.android.lark.contact.customized.department.a.a);
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void c() {
        Log.i("Contact_EnterpriseLoader", "init");
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void e() {
        Log.i("Contact_EnterpriseLoader", "onCleared");
    }

    public EnterpriseContactsLoader(CoroutineScope r2, MutableLiveData<i9b.a<List<m>>> r3, Function3<? super Boolean, ? super Boolean, ? super ErrorResult, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "contactsLiveData");
        Intrinsics.checkNotNullParameter(r4, "reportPerf");
        super(r2, r4);
        this.e = r3;
        this.f = CollectionsKt.emptyList();
    }
}
