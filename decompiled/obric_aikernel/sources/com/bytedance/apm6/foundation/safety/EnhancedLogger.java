package com.bytedance.apm6.foundation.safety;

import com.bytedance.apm6.util.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public class EnhancedLogger extends Logger.DefaultLogger {
    public EnhancedLogger() {
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void e(String r10, String r11) {
        super.e(r10, r11);
        CustomExceptionHelper.reportSlardarIfNeed(r10, r11, null);
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void e(String r10, String r11, Throwable r12) {
        super.e(r10, r11, r12);
        CustomExceptionHelper.reportSlardarIfNeed(r10, r11, r12);
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void wtf(String r10, String r11) {
        super.wtf(r10, r11);
        CustomExceptionHelper.reportSlardarIfNeed(r10, r11, null);
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void wtf(String r10, String r11, Throwable r12) {
        super.wtf(r10, r11, r12);
        CustomExceptionHelper.reportSlardarIfNeed(r10, r11, r12);
    }
}
