package androidx.core.os;

import android.os.LocaleList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList mLocaleList;

    LocaleListPlatformWrapper(Object r3) {
        this.mLocaleList = (LocaleList) ZeusTransformUtils.preCheckCast(r3, LocaleList.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r3) {
        return this.mLocaleList.equals(((LocaleListInterface) ZeusTransformUtils.preCheckCast(r3, LocaleListInterface.class, "com.obric.memorydata.plugin")).getLocaleList());
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int r1) {
        return this.mLocaleList.get(r1);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] r1) {
        return this.mLocaleList.getFirstMatch(r1);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return this.mLocaleList;
    }

    public int hashCode() {
        return this.mLocaleList.hashCode();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale r1) {
        return this.mLocaleList.indexOf(r1);
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mLocaleList.size();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    public String toString() {
        return this.mLocaleList.toString();
    }
}
