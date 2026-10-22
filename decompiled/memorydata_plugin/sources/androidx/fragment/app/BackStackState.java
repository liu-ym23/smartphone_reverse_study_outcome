package androidx.fragment.app;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    static {
        CREATOR = new AnonymousClass1();
    }

    BackStackState(Parcel r2) {
        this.mFragments = r2.createStringArrayList();
        this.mTransactions = r2.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    BackStackState(List<String> r3, List<BackStackRecordState> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<BackStackRecordState> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.mFragments = r5;
        this.mTransactions = r6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    List<BackStackRecord> instantiate(FragmentManager r8, Map<String, Fragment> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap(this.mFragments.size());
        Iterator<String> r2 = this.mFragments.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        Fragment r4 = (Fragment) ZeusTransformUtils.preCheckCast(r10.get(r3), Fragment.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        FragmentState r5 = r8.getFragmentStore().setSavedState(r3, null);
        if (r5 == null) goto L4;
        Fragment r6 = r5.instantiate(r8.getFragmentFactory(), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getHost().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClassLoader());
        r0.put(r6.mWho, r6);
        goto L4
    L7:
        r0.put(r4.mWho, r4);
        goto L4
    L11:
        ArrayList r11 = new ArrayList();
        Iterator<BackStackRecordState> r7 = this.mTransactions.iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        r11.add(((BackStackRecordState) ZeusTransformUtils.preCheckCast(r7.next(), BackStackRecordState.class, "com.obric.memorydata.plugin")).instantiate(r8, r0));
        goto L13
    L15:
        return r11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeStringList(this.mFragments);
        r1.writeTypedList(this.mTransactions);
    }
}
