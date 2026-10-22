package org.bouncycastle.i18n;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes7.dex */
public class TextBundle extends LocalizedMessage {
    public String getText(Locale r3) {
        return getEntry(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r3, TimeZone.getDefault());
    }
}
