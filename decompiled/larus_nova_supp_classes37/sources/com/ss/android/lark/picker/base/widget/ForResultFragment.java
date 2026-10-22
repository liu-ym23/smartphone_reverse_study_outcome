package com.ss.android.lark.picker.base.widget;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R0\u0010\u0004\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/ForResultFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onResult", "Lkotlin/Function1;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "", "getOnResult", "()Lkotlin/jvm/functions/Function1;", "setOnResult", "(Lkotlin/jvm/functions/Function1;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ForResultFragment extends Fragment {
    private Function1<? super List<? extends SearchBaseInfo>, Unit> onResult;

    public ForResultFragment() {
    }

    public final Function1<List<? extends SearchBaseInfo>, Unit> getOnResult() {
        return this.onResult;
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        g r3 = f.b(this);
        if (r3 == null) goto L6;
        r3.a(new AnonymousClass1(this));
        return;
    }

    public final void setOnResult(Function1<? super List<? extends SearchBaseInfo>, Unit> r1) {
        this.onResult = r1;
    }

    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        List r4 = null;
        if (r3 == null) goto L5;
        Serializable r5 = r3.getSerializableExtra("removeData");
    L7:
        if ((r5 instanceof List) == false) goto L9;
        r4 = (List) r5;
    L9:
        Function1<? super List<? extends SearchBaseInfo>, Unit> r6 = this.onResult;
        if (r6 == null) goto L13;
        r6.invoke(r4);
        return;
    L13:
        return;
    L5:
        r5 = null;
        goto L7
    }
}
