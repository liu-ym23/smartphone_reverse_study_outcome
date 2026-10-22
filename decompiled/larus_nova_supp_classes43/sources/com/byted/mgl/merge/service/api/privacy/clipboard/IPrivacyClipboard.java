package com.byted.mgl.merge.service.api.privacy.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IPrivacyClipboard {
    ClipData getPrimaryClip(ClipboardManager r1, String r10) throws IllegalAccessException;

    void setPrimaryClip(ClipboardManager r1, ClipData r10, String r11) throws IllegalAccessException;
}
